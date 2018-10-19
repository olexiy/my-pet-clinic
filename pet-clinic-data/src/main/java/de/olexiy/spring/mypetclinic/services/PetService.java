package de.olexiy.spring.mypetclinic.services;

import de.olexiy.spring.mypetclinic.model.Pet;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
