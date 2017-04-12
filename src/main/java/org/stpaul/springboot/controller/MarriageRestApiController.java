package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Marriage;
import org.stpaul.springboot.service.MarriageService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarriageRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(MarriageRestApiController.class);

    @Autowired
    MarriageService marriageService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/marriage/", method = RequestMethod.GET)
    public ResponseEntity<List<Marriage>> listAllMarriages() {
        List<Marriage> marriages = marriageService.findAllMarriages();
        if (marriages.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Marriage>>(marriages, HttpStatus.OK);
    }

    // -------------------Retrieve Single Marriage------------------------------------------

    @RequestMapping(value = "/marriage/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMarriage(@PathVariable("id") long id) {
        logger.info("Fetching Marriage with id {}", id);
        Marriage marriage = marriageService.findById(id);
        if (marriage == null) {
            logger.error("Marriage with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Marriage with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Marriage>(marriage, HttpStatus.OK);
    }

    // -------------------Create a Marriage-------------------------------------------

    @RequestMapping(value = "/marriage/", method = RequestMethod.POST)
    public ResponseEntity<?> createMarriage(@RequestBody Marriage marriage, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Marriage : {}", marriage);

        if (marriageService.isMarriageExist(marriage)) {
            logger.error("Unable to create. A Marriage with id {} already exist", marriage.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Marriage with id " +
                    marriage.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        marriageService.saveMarriage(marriage);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/marriage/{id}").buildAndExpand(marriage.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Marriage ------------------------------------------------

    @RequestMapping(value = "/marriage/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMarriage(@PathVariable("id") long id, @RequestBody Marriage marriage) {
        logger.info("Updating Marriage with id {}", id);

        Marriage currentMarriage = marriageService.findById(id);

        if (currentMarriage == null) {
            logger.error("Unable to update. Marriage with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Marriage with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentMarriage.setSpouse1(marriage.getSpouse1());
        currentMarriage.setSpouse2(marriage.getSpouse2());
        currentMarriage.setMarriageDate(marriage.getMarriageDate());
        currentMarriage.setMarriagePlace(marriage.getMarriagePlace());
        currentMarriage.setMarriageOfficiant(marriage.getMarriageOfficiant());
        currentMarriage.setWitnessName1(marriage.getWitnessName1());
        currentMarriage.setWitnessName2(marriage.getWitnessName2());
        currentMarriage.setLicenseNumber(marriage.getLicenseNumber());
        currentMarriage.setReturnDate(marriage.getReturnDate());
        currentMarriage.setMarriageComment(marriage.getMarriageComment());

        marriageService.updateMarriage(currentMarriage);
        return new ResponseEntity<Marriage>(currentMarriage, HttpStatus.OK);
    }

    // ------------------- Delete a Marriage-----------------------------------------

    @RequestMapping(value = "/marriage/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMarriage(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Marriage with id {}", id);

        Marriage marriage = marriageService.findById(id);
        if (marriage == null) {
            logger.error("Unable to delete. Marriage with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Marriage with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        marriageService.deleteMarriageById(id);
        return new ResponseEntity<Marriage>(HttpStatus.NO_CONTENT);
    }

}
