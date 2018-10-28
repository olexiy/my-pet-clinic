package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by olsak on Okt, 2018
 **/
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
