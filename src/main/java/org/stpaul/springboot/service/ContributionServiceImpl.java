package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Contribution;
import org.stpaul.springboot.repositories.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("contributionService")
@Transactional
public class ContributionServiceImpl implements ContributionService{

    @Autowired
    private ContributionRepository contributionRepository;

    public Contribution findById(Long id) {
        return contributionRepository.findOne(id);
    }

    @Override
    public Contribution findByName(String name) {return null;}

    public void saveContribution(Contribution contribution) {
        contributionRepository.save(contribution);
    }

    public void updateContribution(Contribution contribution){
        saveContribution(contribution);
    }

    public void deleteContributionById(Long id){
        contributionRepository.delete(id);
    }

    public void deleteAllContributions(){
        contributionRepository.deleteAll();
    }

    public List<Contribution> findAllContributions(){
        return contributionRepository.findAll();
    }

    public boolean isContributionExist(Contribution contribution) {
        Long id;
        if(contribution.getGuestId() != null){
            id = contribution.getGuestId();
        } else{id = contribution.getMemberId();}
        return findById(id) != null;
    }

}