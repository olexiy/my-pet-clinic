package de.olexiy.spring.mypetclinic.services;

import de.olexiy.spring.mypetclinic.model.Owner;

/**
 * Service interface for Owner entities.
 * Provides business logic operations for owner management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
public interface OwnerService extends CrudService<Owner, Long> {
    
    /**
     * Finds an owner by last name.
     */
    Owner findByLastName(String lastName);
}