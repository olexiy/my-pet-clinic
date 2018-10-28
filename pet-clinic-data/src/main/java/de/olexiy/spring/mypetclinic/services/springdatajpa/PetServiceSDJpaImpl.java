package de.olexiy.spring.mypetclinic.services.springdatajpa;

import de.olexiy.spring.mypetclinic.model.Pet;
import de.olexiy.spring.mypetclinic.repositories.PetRepository;
import de.olexiy.spring.mypetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by olsak on Okt, 2018
 **/
@Service
@Profile("springdatajpa")
public class PetServiceSDJpaImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceSDJpaImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Set<Pet> findAll() {
        final Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
