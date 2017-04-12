package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Funeral;

import java.util.List;

public interface FuneralService {
    Funeral findById(Long id);

    Funeral findByName(String name);

    void saveFuneral(Funeral funeral);

    void updateFuneral(Funeral funeral);

    void deleteFuneralById(Long id);

    void deleteAllFunerals();

    List<Funeral> findAllFunerals();

    boolean isFuneralExist(Funeral funeral);
}
