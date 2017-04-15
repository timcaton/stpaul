package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Guest;
import org.stpaul.springboot.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("guestService")
@Transactional
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestRepository guestRepository;

    public Guest findById(Long id) {
        return guestRepository.findOne(id);
    }

    public Guest findByName(String name) {return guestRepository.findByName(name);}

    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public void updateGuest(Guest guest){
        saveGuest(guest);
    }

    public void deleteGuestById(Long id){
        guestRepository.delete(id);
    }

    public void deleteAllGuests(){
        guestRepository.deleteAll();
    }

    public List<Guest> findAllGuests(){
        return guestRepository.findAll();
    }

    public boolean isGuestExist(Guest guest) {
        return findByName(guest.getName()) != null;
    }

}