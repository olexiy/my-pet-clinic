package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.Pet;
import de.olexiy.spring.mypetclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Pet entities.
 * Provides data access operations for pet management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    
    /**
     * Finds pets by name (case-insensitive).
     */
    List<Pet> findByNameIgnoreCase(String name);
    
    /**
     * Finds pets by pet type.
     */
    List<Pet> findByPetType(PetType petType);
    
    /**
     * Finds pets by owner ID.
     */
    List<Pet> findByOwnerId(Long ownerId);
    
    /**
     * Finds pets born after a specific date.
     */
    List<Pet> findByBirthDateAfter(LocalDate date);
    
    /**
     * Finds pets born before a specific date.
     */
    List<Pet> findByBirthDateBefore(LocalDate date);
    
    /**
     * Finds pets born between two dates.
     */
    List<Pet> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
    
    /**
     * Finds a pet by name and owner ID.
     */
    Optional<Pet> findByNameIgnoreCaseAndOwnerId(String name, Long ownerId);
    
    /**
     * Finds pets with visits.
     */
    @Query("SELECT DISTINCT p FROM Pet p WHERE SIZE(p.visits) > 0")
    List<Pet> findPetsWithVisits();
    
    /**
     * Counts pets by type.
     */
    long countByPetType(PetType petType);
    
    /**
     * Finds pets ordered by name.
     */
    List<Pet> findAllByOrderByNameAsc();
}
