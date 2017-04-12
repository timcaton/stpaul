package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Confirmation;

import java.util.List;

public interface ConfirmationService {
    Confirmation findById(Long id);

    Confirmation findByName(String name);

    void saveConfirmation(Confirmation confirmation);

    void updateConfirmation(Confirmation confirmation);

    void deleteConfirmationById(Long id);

    void deleteAllConfirmations();

    List<Confirmation> findAllConfirmations();

    boolean isConfirmationExist(Confirmation confirmation);
}
