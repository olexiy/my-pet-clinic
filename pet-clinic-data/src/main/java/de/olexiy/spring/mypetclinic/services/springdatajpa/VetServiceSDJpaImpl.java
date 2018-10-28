package de.olexiy.spring.mypetclinic.services.springdatajpa;

import de.olexiy.spring.mypetclinic.model.Vet;
import de.olexiy.spring.mypetclinic.repositories.VetRepository;
import de.olexiy.spring.mypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by olsak on Okt, 2018
 **/
@Service
@Profile("springdatajpa")
public class VetServiceSDJpaImpl implements VetService {

    private final VetRepository vetRepository;

    public VetServiceSDJpaImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
