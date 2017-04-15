package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Guest;

import java.util.List;

public interface GuestService {
    Guest findById(Long id);

    Guest findByName(String name);

    void saveGuest(Guest guest);

    void updateGuest(Guest guest);

    void deleteGuestById(Long id);

    void deleteAllGuests();

    List<Guest> findAllGuests();

    boolean isGuestExist(Guest guest);
}
