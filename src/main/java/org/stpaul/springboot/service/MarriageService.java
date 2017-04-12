package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Marriage;

import java.util.List;

public interface MarriageService {
    Marriage findById(Long id);

    Marriage findByName(String name);

    void saveMarriage(Marriage marriage);

    void updateMarriage(Marriage marriage);

    void deleteMarriageById(Long id);

    void deleteAllMarriages();

    List<Marriage> findAllMarriages();

    boolean isMarriageExist(Marriage marriage);
}
