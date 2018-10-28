package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by olsak on Okt, 2018
 **/
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
