package de.olexiy.spring.mypetclinic.services.springdatajpa;

import de.olexiy.spring.mypetclinic.model.Owner;
import de.olexiy.spring.mypetclinic.repositories.OwnerRepository;
import de.olexiy.spring.mypetclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Spring Data JPA implementation of OwnerService.
 * Provides owner management operations using JPA repositories.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Slf4j
@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OwnerServiceSDJpaImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner findByLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            log.warn("Attempted to find owner with empty last name");
            return null;
        }
        return ownerRepository.findByLastNameIgnoreCase(lastName.trim()).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        if (id == null) {
            log.warn("Attempted to find owner with null ID");
            return null;
        }
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Owner save(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }
        
        log.debug("Saving owner: {}", owner.getFirstName() + " " + owner.getLastName());
        return ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void delete(Owner owner) {
        if (owner == null) {
            log.warn("Attempted to delete null owner");
            return;
        }
        log.debug("Deleting owner: {}", owner.getFirstName() + " " + owner.getLastName());
        ownerRepository.delete(owner);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id == null) {
            log.warn("Attempted to delete owner with null ID");
            return;
        }
        log.debug("Deleting owner with ID: {}", id);
        ownerRepository.deleteById(id);
    }
}