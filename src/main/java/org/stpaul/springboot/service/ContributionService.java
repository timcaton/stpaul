package org.stpaul.springboot.service;

import org.stpaul.springboot.model.Contribution;

import java.util.List;

public interface ContributionService {
    Contribution findById(Long id);

    Contribution findByName(String name);

    void saveContribution(Contribution contribution);

    void updateContribution(Contribution contribution);

    void deleteContributionById(Long id);

    void deleteAllContributions();

    List<Contribution> findAllContributions();

    boolean isContributionExist(Contribution contribution);
}
