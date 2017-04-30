package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Marriage;
import org.stpaul.springboot.repositories.MarriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("marriageService")
@Transactional
public class MarriageServiceImpl implements MarriageService{

    @Autowired
    private MarriageRepository marriageRepository;

    public Marriage findById(Long id) {
        return marriageRepository.findOne(id);
    }

    @Override
    public Marriage findByName(String name) {
        return null;
    }

    public void saveMarriage(Marriage marriage) {
        marriageRepository.save(marriage);
    }

    public void updateMarriage(Marriage marriage){
        saveMarriage(marriage);
    }

    public void deleteMarriageById(Long id){
        marriageRepository.delete(id);
    }

    public void deleteAllMarriages(){
        marriageRepository.deleteAll();
    }

    public List<Marriage> findAllMarriages(){
        return marriageRepository.findAll();
    }

    public boolean isMarriageExist(Marriage marriage) {
        if(marriage.getId() != null) {
            return true;
        }
        else return false;
    }
}