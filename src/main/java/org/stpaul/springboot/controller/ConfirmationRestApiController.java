package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Confirmation;
import org.stpaul.springboot.service.ConfirmationService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConfirmationRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(ConfirmationRestApiController.class);

    @Autowired
    ConfirmationService confirmationService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/confirmation/", method = RequestMethod.GET)
    public ResponseEntity<List<Confirmation>> listAllConfirmations() {
        List<Confirmation> confirmations = confirmationService.findAllConfirmations();
        if (confirmations.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Confirmation>>(confirmations, HttpStatus.OK);
    }

    // -------------------Retrieve Single Confirmation------------------------------------------

    @RequestMapping(value = "/confirmation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getConfirmation(@PathVariable("id") long id) {
        logger.info("Fetching Confirmation with id {}", id);
        Confirmation confirmation = confirmationService.findById(id);
        if (confirmation == null) {
            logger.error("Confirmation with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Confirmation with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Confirmation>(confirmation, HttpStatus.OK);
    }

    // -------------------Create a Confirmation-------------------------------------------

    @RequestMapping(value = "/confirmation/", method = RequestMethod.POST)
    public ResponseEntity<?> createConfirmation(@RequestBody Confirmation confirmation, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Confirmation : {}", confirmation);

        if (confirmationService.isConfirmationExist(confirmation)) {
            logger.error("Unable to create. A Confirmation with id {} already exist", confirmation.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Confirmation with id " +
                    confirmation.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        confirmationService.saveConfirmation(confirmation);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/confirmation/{id}").buildAndExpand(confirmation.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Confirmation ------------------------------------------------

    @RequestMapping(value = "/confirmation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateConfirmation(@PathVariable("id") long id, @RequestBody Confirmation confirmation) {
        logger.info("Updating Confirmation with id {}", id);

        Confirmation currentConfirmation = confirmationService.findById(id);

        if (currentConfirmation == null) {
            logger.error("Unable to update. Confirmation with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Confirmation with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentConfirmation.setMemberId(confirmation.getMemberId());
        currentConfirmation.setConfirmationDate(confirmation.getConfirmationDate());
        currentConfirmation.setConfirmationLocation(confirmation.getConfirmationLocation());
        currentConfirmation.setConfirmationOfficiant(confirmation.getConfirmationOfficiant());
        currentConfirmation.setConfirmationComment(confirmation.getConfirmationComment());
        currentConfirmation.setConfirmationVerse(confirmation.getConfirmationVerse());
        currentConfirmation.setExaminationDate(confirmation.getExaminationDate());

        confirmationService.updateConfirmation(currentConfirmation);
        return new ResponseEntity<Confirmation>(currentConfirmation, HttpStatus.OK);
    }

    // ------------------- Delete a Confirmation-----------------------------------------

    @RequestMapping(value = "/confirmation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteConfirmation(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Confirmation with id {}", id);

        Confirmation confirmation = confirmationService.findById(id);
        if (confirmation == null) {
            logger.error("Unable to delete. Confirmation with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Confirmation with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        confirmationService.deleteConfirmationById(id);
        return new ResponseEntity<Confirmation>(HttpStatus.NO_CONTENT);
    }

}
