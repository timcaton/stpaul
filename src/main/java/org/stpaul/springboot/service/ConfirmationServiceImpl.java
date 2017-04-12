package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Confirmation;
import org.stpaul.springboot.repositories.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("confirmationService")
@Transactional
public class ConfirmationServiceImpl implements ConfirmationService{

    @Autowired
    private ConfirmationRepository confirmationRepository;

    public Confirmation findById(Long id) {
        return confirmationRepository.findOne(id);
    }

    @Override
    public Confirmation findByName(String name) {
        return null;
    }

    public void saveConfirmation(Confirmation confirmation) {
        confirmationRepository.save(confirmation);
    }

    public void updateConfirmation(Confirmation confirmation){
        saveConfirmation(confirmation);
    }

    public void deleteConfirmationById(Long id){
        confirmationRepository.delete(id);
    }

    public void deleteAllConfirmations(){
        confirmationRepository.deleteAll();
    }

    public List<Confirmation> findAllConfirmations(){
        return confirmationRepository.findAll();
    }

    public boolean isConfirmationExist(Confirmation confirmation) {
        return findById(confirmation.getMemberId()) != null;
    }

}