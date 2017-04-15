package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Baptism;
import org.stpaul.springboot.repositories.BaptismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("baptismService")
@Transactional
public class BaptismServiceImpl implements BaptismService{

    @Autowired
    private BaptismRepository baptismRepository;

    public Baptism findById(Long id) {
        return baptismRepository.findOne(id);
    }

    @Override
    public Baptism findByName(String name) {return null;}

    public void saveBaptism(Baptism baptism) {
        baptismRepository.save(baptism);
    }

    public void updateBaptism(Baptism baptism){
        saveBaptism(baptism);
    }

    public void deleteBaptismById(Long id){
        baptismRepository.delete(id);
    }

    public void deleteAllBaptisms(){
        baptismRepository.deleteAll();
    }

    public List<Baptism> findAllBaptisms(){
        return baptismRepository.findAll();
    }

    public boolean isBaptismExist(Baptism baptism) {
        return findById(baptism.getMemberId()) != null;
    }

}