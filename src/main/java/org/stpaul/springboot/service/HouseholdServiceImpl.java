package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Household;
import org.stpaul.springboot.repositories.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("householdService")
@Transactional
public class HouseholdServiceImpl implements HouseholdService{

    @Autowired
    private HouseholdRepository householdRepository;

    public Household findById(Long id) {
        return householdRepository.findOne(id);
    }

    public Household findByName(String name) {
        return householdRepository.findByName(name);
    }

    public void saveHousehold(Household household) {
        householdRepository.save(household);
    }

    public void updateHousehold(Household household){
        saveHousehold(household);
    }

    public void deleteHouseholdById(Long id){
        householdRepository.delete(id);
    }

    public void deleteAllHouseholds(){
        householdRepository.deleteAll();
    }

    public List<Household> findAllHouseholds(){
        return householdRepository.findAll();
    }

    public boolean isHouseholdExist(Household household) {
        return findByName(household.getName()) != null;
    }

}