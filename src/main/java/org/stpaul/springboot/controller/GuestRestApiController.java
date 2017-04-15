package org.stpaul.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.stpaul.springboot.model.Guest;
import org.stpaul.springboot.service.GuestService;
import org.stpaul.springboot.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(GuestRestApiController.class);

    @Autowired
    GuestService guestService;

    // -------------------Retrieve All Members---------------------------------------------

    @RequestMapping(value = "/guest/", method = RequestMethod.GET)
    public ResponseEntity<List<Guest>> listAllGuests() {
        List<Guest> guests = guestService.findAllGuests();
        if (guests.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Guest>>(guests, HttpStatus.OK);
    }

    // -------------------Retrieve Single Guest------------------------------------------

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getGuest(@PathVariable("id") long id) {
        logger.info("Fetching Guest with id {}", id);
        Guest guest = guestService.findById(id);
        if (guest == null) {
            logger.error("Guest with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Guest with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Guest>(guest, HttpStatus.OK);
    }

    // -------------------Create a Guest-------------------------------------------

    @RequestMapping(value = "/guest/", method = RequestMethod.POST)
    public ResponseEntity<?> createGuest(@RequestBody Guest guest, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Guest : {}", guest);

        if (guestService.isGuestExist(guest)) {
            logger.error("Unable to create. A Guest with id {} already exist", guest.getId());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Guest with id " +
                    guest.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        guestService.saveGuest(guest);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/guest/{id}").buildAndExpand(guest.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Guest ------------------------------------------------

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGuest(@PathVariable("id") long id, @RequestBody Guest guest) {
        logger.info("Updating Guest with id {}", id);

        Guest currentGuest = guestService.findById(id);

        if (currentGuest == null) {
            logger.error("Unable to update. Guest with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Guest with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentGuest.setId(guest.getId());
        currentGuest.setName(guest.getName());
        currentGuest.setAddress(guest.getAddress());
        currentGuest.setPhone(guest.getPhone());
        currentGuest.setHomeChurch(guest.getHomeChurch());
        currentGuest.setCommunionDate(guest.getCommunionDate());
        currentGuest.setGuestEmail(guest.getGuestEmail());
        currentGuest.setGuestComment(guest.getGuestComment());

        guestService.updateGuest(currentGuest);
        return new ResponseEntity<Guest>(currentGuest, HttpStatus.OK);
    }

    // ------------------- Delete a Guest-----------------------------------------

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGuest(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Guest with id {}", id);

        Guest guest = guestService.findById(id);
        if (guest == null) {
            logger.error("Unable to delete. Guest with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Guest with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        guestService.deleteGuestById(id);
        return new ResponseEntity<Guest>(HttpStatus.NO_CONTENT);
    }

}
