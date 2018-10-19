package de.olexiy.spring.mypetclinic.services;

import de.olexiy.spring.mypetclinic.model.Owner;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
