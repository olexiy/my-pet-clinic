package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Owner entities.
 * Provides data access operations for owner management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    
    /**
     * Finds an owner by last name (case-insensitive).
     */
    Optional<Owner> findByLastNameIgnoreCase(String lastName);
    
    /**
     * Finds owners whose last name contains the given string (case-insensitive).
     */
    List<Owner> findByLastNameContainingIgnoreCase(String lastName);
    
    /**
     * Finds owners by city (case-insensitive).
     */
    List<Owner> findByCityIgnoreCase(String city);
    
    /**
     * Finds an owner by telephone number.
     */
    Optional<Owner> findByTelephone(String telephone);
    
    /**
     * Finds owners with pets of a specific type.
     */
    @Query("SELECT DISTINCT o FROM Owner o JOIN o.pets p WHERE p.petType.name = :petTypeName")
    List<Owner> findByPetType(@Param("petTypeName") String petTypeName);
    
    /**
     * Finds owners by first and last name (case-insensitive).
     */
    Optional<Owner> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
    
    /**
     * Checks if an owner exists with the given telephone number.
     */
    boolean existsByTelephone(String telephone);
}
