package io.swagger.util;

import io.swagger.model.Individual;
import io.swagger.model.IndividualCreate;
import io.swagger.model.IndividualUpdate;

public class Mapper {

    public static Individual createToIndividual(IndividualCreate individualCreate) {

        Individual individual = new Individual();
        individual.setId(individualCreate.getId());
        individual.setFamilyName(individualCreate.getFamilyName());
        individual.setFullName(individualCreate.getFullName());
        individual.setHref(individualCreate.getHref());
        individual.setAristocraticTitle(individualCreate.getAristocraticTitle());
        individual.setCountryOfBirth(individualCreate.getCountryOfBirth());
        individual.setDeathDate(individualCreate.getDeathDate());
        individual.setGender(individualCreate.getGender());
        individual.setBaseType(individualCreate.getBaseType());
        individual.setBirthDate(individualCreate.getBirthDate());
        individual.setSchemaLocation(individualCreate.getSchemaLocation());
        individual.setType(individualCreate.getType());
        return individual;
    }

    public static Individual updateToIndividual(IndividualUpdate individualUpdate, String id) {

        Individual individual = new Individual();
        individual.setId(id);
        individual.setFamilyName(individualUpdate.getFamilyName());
        individual.setFullName(individualUpdate.getFullName());
        individual.setHref(individualUpdate.getHref());
        individual.setAristocraticTitle(individualUpdate.getAristocraticTitle());
        individual.setCountryOfBirth(individualUpdate.getCountryOfBirth());
        individual.setDeathDate(individualUpdate.getDeathDate());
        individual.setGender(individualUpdate.getGender());
        individual.setBaseType(individualUpdate.getBaseType());
        individual.setBirthDate(individualUpdate.getBirthDate());
        individual.setSchemaLocation(individualUpdate.getSchemaLocation());
        individual.setType(individualUpdate.getType());
        return individual;
    }
}
