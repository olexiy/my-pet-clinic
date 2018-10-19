package de.olexiy.spring.mypetclinic.services;

import de.olexiy.spring.mypetclinic.model.Owner;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public interface OwnerService {

    Owner findById(Long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
