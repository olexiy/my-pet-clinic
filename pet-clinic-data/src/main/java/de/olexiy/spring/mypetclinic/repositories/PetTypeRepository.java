package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for PetType entities.
 * Provides data access operations for pet type management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    
    /**
     * Finds a pet type by name (case-insensitive).
     */
    Optional<PetType> findByNameIgnoreCase(String name);
    
    /**
     * Finds pet types whose name contains the given string (case-insensitive).
     */
    List<PetType> findByNameContainingIgnoreCase(String name);
    
    /**
     * Finds all pet types ordered by name.
     */
    List<PetType> findAllByOrderByNameAsc();
    
    /**
     * Checks if a pet type exists with the given name.
     */
    boolean existsByNameIgnoreCase(String name);
}
