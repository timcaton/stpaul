package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Household;
import org.stpaul.springboot.service.HouseholdService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouseholdRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(HouseholdRestApiController.class);

    @Autowired
    HouseholdService householdService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/household/", method = RequestMethod.GET)
    public ResponseEntity<List<Household>> listAllHouseholds() {
        List<Household> households = householdService.findAllHouseholds();
        if (households.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Household>>(households, HttpStatus.OK);
    }

    // -------------------Retrieve Single Household------------------------------------------

    @RequestMapping(value = "/household/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getHousehold(@PathVariable("id") long id) {
        logger.info("Fetching Household with id {}", id);
        Household household = householdService.findById(id);
        if (household == null) {
            logger.error("Household with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Household with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Household>(household, HttpStatus.OK);
    }

    // -------------------Create a Household-------------------------------------------

    @RequestMapping(value = "/household/", method = RequestMethod.POST)
    public ResponseEntity<?> createHousehold(@RequestBody Household household, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Household : {}", household);

        if (householdService.isHouseholdExist(household)) {
            logger.error("Unable to create. A Household with id {} already exist", household.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Household with id " +
                    household.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        householdService.saveHousehold(household);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/household/{id}").buildAndExpand(household.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Household ------------------------------------------------

    @RequestMapping(value = "/household/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateHousehold(@PathVariable("id") long id, @RequestBody Household household) {
        logger.info("Updating Household with id {}", id);

        Household currentHousehold = householdService.findById(id);

        if (currentHousehold == null) {
            logger.error("Unable to update. Household with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Household with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentHousehold.setMemberId(household.getMemberId());
        currentHousehold.setName(household.getName());
        currentHousehold.setHouseholdType(household.getHouseholdType());

        householdService.updateHousehold(currentHousehold);
        return new ResponseEntity<Household>(currentHousehold, HttpStatus.OK);
    }

    // ------------------- Delete a Household-----------------------------------------

    @RequestMapping(value = "/household/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteHousehold(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Household with id {}", id);

        Household household = householdService.findById(id);
        if (household == null) {
            logger.error("Unable to delete. Household with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Household with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        householdService.deleteHouseholdById(id);
        return new ResponseEntity<Household>(HttpStatus.NO_CONTENT);
    }

}
