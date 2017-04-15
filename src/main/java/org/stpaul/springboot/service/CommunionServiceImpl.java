package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Communion;
import org.stpaul.springboot.repositories.CommunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("communionService")
@Transactional
public class CommunionServiceImpl implements CommunionService{

    @Autowired
    private CommunionRepository communionRepository;

    public Communion findById(Long id) {
        return communionRepository.findOne(id);
    }

    @Override
    public Communion findByName(String name) {
        return null;
    }

    public void saveCommunion(Communion communion) {
        communionRepository.save(communion);
    }

    public void updateCommunion(Communion communion){
        saveCommunion(communion);
    }

    public void deleteCommunionById(Long id){
        communionRepository.delete(id);
    }

    public void deleteAllCommunions(){
        communionRepository.deleteAll();
    }

    public List<Communion> findAllCommunions(){
        return communionRepository.findAll();
    }

    public boolean isCommunionExist(Communion communion) {
        return findById(communion.getMemberId()) != null;
    }
}