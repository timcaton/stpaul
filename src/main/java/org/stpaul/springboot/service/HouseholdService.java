package org.stpaul.springboot.service;


import org.stpaul.springboot.model.Household;

import java.util.List;

public interface HouseholdService {

    Household findById(Long id);

    Household findByName(String name);

    void saveHousehold(Household household);

    void updateHousehold(Household household);

    void deleteHouseholdById(Long id);

    void deleteAllHouseholds();

    List<Household> findAllHouseholds();

    boolean isHouseholdExist(Household household);
}