package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Funeral;
import org.stpaul.springboot.service.FuneralService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuneralRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(FuneralRestApiController.class);

    @Autowired
    FuneralService funeralService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/funeral/", method = RequestMethod.GET)
    public ResponseEntity<List<Funeral>> listAllFunerals() {
        List<Funeral> funerals = funeralService.findAllFunerals();
        if (funerals.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Funeral>>(funerals, HttpStatus.OK);
    }

    // -------------------Retrieve Single Funeral------------------------------------------

    @RequestMapping(value = "/funeral/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFuneral(@PathVariable("id") long id) {
        logger.info("Fetching Funeral with id {}", id);
        Funeral funeral = funeralService.findById(id);
        if (funeral == null) {
            logger.error("Funeral with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Funeral with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Funeral>(funeral, HttpStatus.OK);
    }

    // -------------------Create a Funeral-------------------------------------------

    @RequestMapping(value = "/funeral/", method = RequestMethod.POST)
    public ResponseEntity<?> createFuneral(@RequestBody Funeral funeral, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Funeral : {}", funeral);

        if (funeralService.isFuneralExist(funeral)) {
            logger.error("Unable to create. A Funeral with id {} already exist", funeral.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Funeral with id " +
                    funeral.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        funeralService.saveFuneral(funeral);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/funeral/{id}").buildAndExpand(funeral.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Funeral ------------------------------------------------

    @RequestMapping(value = "/funeral/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFuneral(@PathVariable("id") long id, @RequestBody Funeral funeral) {
        logger.info("Updating Funeral with id {}", id);

        Funeral currentFuneral = funeralService.findById(id);

        if (currentFuneral == null) {
            logger.error("Unable to update. Funeral with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Funeral with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentFuneral.setMemberId(funeral.getMemberId());
        currentFuneral.setFuneralDate(funeral.getFuneralDate());
        currentFuneral.setFuneralPlace(funeral.getFuneralPlace());
        currentFuneral.setFuneralOfficiant(funeral.getFuneralOfficiant());
        currentFuneral.setFuneralComment(funeral.getFuneralComment());
        currentFuneral.setBurialLocation(funeral.getBurialLocation());
        currentFuneral.setDeathDate(funeral.getDeathDate());
        currentFuneral.setPallBearers(funeral.getPallBearers());

        funeralService.updateFuneral(currentFuneral);
        return new ResponseEntity<Funeral>(currentFuneral, HttpStatus.OK);
    }

    // ------------------- Delete a Funeral-----------------------------------------

    @RequestMapping(value = "/funeral/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFuneral(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Funeral with id {}", id);

        Funeral funeral = funeralService.findById(id);
        if (funeral == null) {
            logger.error("Unable to delete. Funeral with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Funeral with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        funeralService.deleteFuneralById(id);
        return new ResponseEntity<Funeral>(HttpStatus.NO_CONTENT);
    }

}
