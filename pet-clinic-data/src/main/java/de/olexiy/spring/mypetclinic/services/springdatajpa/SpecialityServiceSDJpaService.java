package de.olexiy.spring.mypetclinic.services.springdatajpa;

import de.olexiy.spring.mypetclinic.model.Speciality;
import de.olexiy.spring.mypetclinic.repositories.SpecialityRepository;
import de.olexiy.spring.mypetclinic.services.SpeciaalitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by olsak on Okt, 2018
 **/
@Service
@Profile("springdatajpa")
public class SpecialityServiceSDJpaService implements SpeciaalitiesService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceSDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        final Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
