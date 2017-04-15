package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Communion;

import java.util.List;

public interface CommunionService {
    Communion findById(Long id);

    Communion findByName(String name);

    void saveCommunion(Communion communion);

    void updateCommunion(Communion communion);

    void deleteCommunionById(Long id);

    void deleteAllCommunions();

    List<Communion> findAllCommunions();

    boolean isCommunionExist(Communion communion);
}
