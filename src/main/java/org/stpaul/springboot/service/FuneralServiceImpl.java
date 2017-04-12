package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Funeral;
import org.stpaul.springboot.repositories.FuneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("funeralService")
@Transactional
public class FuneralServiceImpl implements FuneralService{

    @Autowired
    private FuneralRepository funeralRepository;

    public Funeral findById(Long id) {
        return funeralRepository.findOne(id);
    }

    @Override
    public Funeral findByName(String name) {
        return null;
    }

    public void saveFuneral(Funeral funeral) {
        funeralRepository.save(funeral);
    }

    public void updateFuneral(Funeral funeral){
        saveFuneral(funeral);
    }

    public void deleteFuneralById(Long id){
        funeralRepository.delete(id);
    }

    public void deleteAllFunerals(){
        funeralRepository.deleteAll();
    }

    public List<Funeral> findAllFunerals(){
        return funeralRepository.findAll();
    }

    public boolean isFuneralExist(Funeral funeral) {
        return findById(funeral.getMemberId()) != null;
    }

}