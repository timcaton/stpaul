package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Communion;
import org.stpaul.springboot.service.CommunionService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommunionRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(CommunionRestApiController.class);

    @Autowired
    CommunionService communionService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/communion/", method = RequestMethod.GET)
    public ResponseEntity<List<Communion>> listAllCommunions() {
        List<Communion> communions = communionService.findAllCommunions();
        if (communions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Communion>>(communions, HttpStatus.OK);
    }

    // -------------------Retrieve Single Communion------------------------------------------

    @RequestMapping(value = "/communion/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCommunion(@PathVariable("id") long id) {
        logger.info("Fetching Communion with id {}", id);
        Communion communion = communionService.findById(id);
        if (communion == null) {
            logger.error("Communion with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Communion with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Communion>(communion, HttpStatus.OK);
    }

    // -------------------Create a Communion-------------------------------------------

    @RequestMapping(value = "/communion/", method = RequestMethod.POST)
    public ResponseEntity<?> createCommunion(@RequestBody Communion communion, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Communion : {}", communion);

        if (communionService.isCommunionExist(communion)) {
            logger.error("Unable to create. A Communion with id {} already exist", communion.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Communion with id " +
                    communion.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        communionService.saveCommunion(communion);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/communion/{id}").buildAndExpand(communion.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Communion ------------------------------------------------

    @RequestMapping(value = "/communion/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCommunion(@PathVariable("id") long id, @RequestBody Communion communion) {
        logger.info("Updating Communion with id {}", id);

        Communion currentCommunion = communionService.findById(id);

        if (currentCommunion == null) {
            logger.error("Unable to update. Communion with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Communion with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentCommunion.setId(communion.getId());
        currentCommunion.setMemberId(communion.getMemberId());
        currentCommunion.setCommunionDate(communion.getCommunionDate());

        communionService.updateCommunion(currentCommunion);
        return new ResponseEntity<Communion>(currentCommunion, HttpStatus.OK);
    }

    // ------------------- Delete a Communion-----------------------------------------

    @RequestMapping(value = "/communion/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommunion(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Communion with id {}", id);

        Communion communion = communionService.findById(id);
        if (communion == null) {
            logger.error("Unable to delete. Communion with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Communion with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        communionService.deleteCommunionById(id);
        return new ResponseEntity<Communion>(HttpStatus.NO_CONTENT);
    }

}
