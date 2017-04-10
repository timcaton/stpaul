package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Baptism;

import java.util.List;

public interface BaptismService {
    Baptism findById(Long id);

    Baptism findByName(String name);

    void saveBaptism(Baptism member);

    void updateBaptism(Baptism member);

    void deleteBaptismById(Long id);

    void deleteAllBaptisms();

    List<Baptism> findAllBaptisms();

    boolean isBaptismExist(Baptism member);
}
