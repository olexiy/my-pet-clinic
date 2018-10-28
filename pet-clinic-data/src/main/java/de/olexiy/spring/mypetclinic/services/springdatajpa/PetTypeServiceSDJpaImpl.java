package de.olexiy.spring.mypetclinic.services.springdatajpa;

import de.olexiy.spring.mypetclinic.model.PetType;
import de.olexiy.spring.mypetclinic.repositories.PetTypeRepository;
import de.olexiy.spring.mypetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by olsak on Okt, 2018
 **/
@Service
@Profile("springdatajpa")
public class PetTypeServiceSDJpaImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceSDJpaImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        final Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
