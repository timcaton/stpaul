package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Baptism;
import org.stpaul.springboot.service.BaptismService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BaptismRestApiController {

        public static final Logger logger = LoggerFactory.getLogger(BaptismRestApiController.class);

        @Autowired
        BaptismService baptismService;

        // -------------------Retrieve All Members---------------------------------------------

        @RequestMapping(value = "/baptism/", method = RequestMethod.GET)
        public ResponseEntity<List<Baptism>> listAllBaptisms() {
            List<Baptism> baptisms = baptismService.findAllBaptisms();
            if (baptisms.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<Baptism>>(baptisms, HttpStatus.OK);
        }

        // -------------------Retrieve Single Baptism------------------------------------------

        @RequestMapping(value = "/baptism/{id}", method = RequestMethod.GET)
        public ResponseEntity<?> getBaptism(@PathVariable("id") long id) {
            logger.info("Fetching Baptism with id {}", id);
            Baptism baptism = baptismService.findById(id);
            if (baptism == null) {
                logger.error("Baptism with id {} not found.", id);
                return new ResponseEntity(new CustomErrorType("Baptism with id " + id
                        + " not found"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Baptism>(baptism, HttpStatus.OK);
        }

        // -------------------Create a Baptism-------------------------------------------

        @RequestMapping(value = "/baptism/", method = RequestMethod.POST)
        public ResponseEntity<?> createBaptism(@RequestBody Baptism baptism, UriComponentsBuilder ucBuilder) {
            logger.info("Creating Baptism : {}", baptism);

            if (baptismService.isBaptismExist(baptism)) {
                logger.error("Unable to create. A Baptism with id {} already exist", baptism.getId());
                return new ResponseEntity(new CustomErrorType("Unable to create. A Baptism with id " +
                        baptism.getId() + " already exist."),HttpStatus.CONFLICT);
            }
            baptismService.saveBaptism(baptism);

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/api/baptism/{id}").buildAndExpand(baptism.getId()).toUri());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        }

        // ------------------- Update a Baptism ------------------------------------------------

        @RequestMapping(value = "/baptism/{id}", method = RequestMethod.PUT)
        public ResponseEntity<?> updateBaptism(@PathVariable("id") long id, @RequestBody Baptism baptism) {
            logger.info("Updating Baptism with id {}", id);

            Baptism currentBaptism = baptismService.findById(id);

            if (currentBaptism == null) {
                logger.error("Unable to update. Baptism with id {} not found.", id);
                return new ResponseEntity(new CustomErrorType("Unable to upate. Baptism with id " + id + " not found."),
                        HttpStatus.NOT_FOUND);
            }

            currentBaptism.setMemberId(baptism.getMemberId());
            currentBaptism.setBaptismDate(baptism.getBaptismDate());
            currentBaptism.setBaptismLocation(baptism.getBaptismLocation());
            currentBaptism.setBaptismOfficiant(baptism.getBaptismOfficiant());
            currentBaptism.setSponsorName(baptism.getSponsorName());
            currentBaptism.setWitnessName(baptism.getWitnessName());
            currentBaptism.setBaptismComment(baptism.getBaptismComment());

            baptismService.updateBaptism(currentBaptism);
            return new ResponseEntity<Baptism>(currentBaptism, HttpStatus.OK);
        }

        // ------------------- Delete a Baptism-----------------------------------------

        @RequestMapping(value = "/baptism/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<?> deleteBaptism(@PathVariable("id") long id) {
            logger.info("Fetching & Deleting Baptism with id {}", id);

            Baptism baptism = baptismService.findById(id);
            if (baptism == null) {
                logger.error("Unable to delete. Baptism with id {} not found.", id);
                return new ResponseEntity(new CustomErrorType("Unable to delete. Baptism with id " + id + " not found."),
                        HttpStatus.NOT_FOUND);
            }
            baptismService.deleteBaptismById(id);
            return new ResponseEntity<Baptism>(HttpStatus.NO_CONTENT);
        }

}
