package io.swagger.service;

import io.swagger.model.Individual;
import io.swagger.repository.IndividualRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndividualService {

    private final IndividualRepository individualRepository;

    public List<Individual> getAllIndividuals() {
        return individualRepository.findAll();
    }

    public IndividualService(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    public Individual getIndividualById(String individualId) {
        return individualRepository.findOne(individualId);
    }

    public Individual createIndividual(Individual individual) {
        return individualRepository.save(individual);
    }

    public Individual updateIndividual(Individual individualDetails){
        Individual individual = individualRepository.findOne(individualDetails.getId());
        if (individual != null) {
            individualRepository.save(individualDetails);
            return individual;
        } else {
            return null;
        }
    }

    public boolean deleteIndividual(String individualId) {
        Individual individual = individualRepository.findOne(individualId);
        if (individual != null) {
            individualRepository.delete(individualId);
            return true;
        } else {
            return false;
        }
    }
}
