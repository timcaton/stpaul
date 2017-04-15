package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Contribution;
import org.stpaul.springboot.service.ContributionService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContributionRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(ContributionRestApiController.class);

    @Autowired
    ContributionService contributionService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/contribution/", method = RequestMethod.GET)
    public ResponseEntity<List<Contribution>> listAllContributions() {
        List<Contribution> contributions = contributionService.findAllContributions();
        if (contributions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Contribution>>(contributions, HttpStatus.OK);
    }

    // -------------------Retrieve Single Contribution------------------------------------------

    @RequestMapping(value = "/contribution/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getContribution(@PathVariable("id") long id) {
        logger.info("Fetching Contribution with id {}", id);
        Contribution contribution = contributionService.findById(id);
        if (contribution == null) {
            logger.error("Contribution with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Contribution with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Contribution>(contribution, HttpStatus.OK);
    }

    // -------------------Create a Contribution-------------------------------------------

    @RequestMapping(value = "/contribution/", method = RequestMethod.POST)
    public ResponseEntity<?> createContribution(@RequestBody Contribution contribution, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Contribution : {}", contribution);

        if (contributionService.isContributionExist(contribution)) {
            logger.error("Unable to create. A Contribution with id {} already exist", contribution.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Contribution with id " +
                    contribution.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        contributionService.saveContribution(contribution);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/contribution/{id}").buildAndExpand(contribution.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Contribution ------------------------------------------------

    @RequestMapping(value = "/contribution/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateContribution(@PathVariable("id") long id, @RequestBody Contribution contribution) {
        logger.info("Updating Contribution with id {}", id);

        Contribution currentContribution = contributionService.findById(id);

        if (currentContribution == null) {
            logger.error("Unable to update. Contribution with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Contribution with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentContribution.setId(contribution.getId());
        currentContribution.setMemberId(contribution.getMemberId());
        currentContribution.setGuestId(contribution.getGuestId());
        currentContribution.setPurpose(contribution.getPurpose());
        currentContribution.setMethod(contribution.getMethod());
        currentContribution.setContributionDate(contribution.getContributionDate());
        currentContribution.setAmount(contribution.getAmount());

        contributionService.updateContribution(currentContribution);
        return new ResponseEntity<Contribution>(currentContribution, HttpStatus.OK);
    }

    // ------------------- Delete a Contribution-----------------------------------------

    @RequestMapping(value = "/contribution/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContribution(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Contribution with id {}", id);

        Contribution contribution = contributionService.findById(id);
        if (contribution == null) {
            logger.error("Unable to delete. Contribution with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Contribution with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        contributionService.deleteContributionById(id);
        return new ResponseEntity<Contribution>(HttpStatus.NO_CONTENT);
    }

}
