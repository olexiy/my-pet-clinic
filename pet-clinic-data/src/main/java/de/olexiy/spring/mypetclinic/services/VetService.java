package de.olexiy.spring.mypetclinic.services;

import de.olexiy.spring.mypetclinic.model.Vet;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
