package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.Speciality;
import de.olexiy.spring.mypetclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Vet entities.
 * Provides data access operations for veterinarian management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    
    /**
     * Finds a vet by last name (case-insensitive).
     */
    Optional<Vet> findByLastNameIgnoreCase(String lastName);
    
    /**
     * Finds vets whose last name contains the given string (case-insensitive).
     */
    List<Vet> findByLastNameContainingIgnoreCase(String lastName);
    
    /**
     * Finds vets by first and last name (case-insensitive).
     */
    Optional<Vet> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
    
    /**
     * Finds vets with a specific speciality.
     */
    @Query("SELECT DISTINCT v FROM Vet v JOIN v.specialities s WHERE s.description = :specialityDescription")
    List<Vet> findBySpeciality(@Param("specialityDescription") String specialityDescription);
    
    /**
     * Finds vets with any of the given specialities.
     */
    @Query("SELECT DISTINCT v FROM Vet v JOIN v.specialities s WHERE s IN :specialities")
    List<Vet> findBySpecialitiesIn(@Param("specialities") List<Speciality> specialities);
    
    /**
     * Finds all vets ordered by last name.
     */
    List<Vet> findAllByOrderByLastNameAsc();
    
    /**
     * Counts vets with a specific speciality.
     */
    @Query("SELECT COUNT(DISTINCT v) FROM Vet v JOIN v.specialities s WHERE s.description = :specialityDescription")
    long countBySpeciality(@Param("specialityDescription") String specialityDescription);
}
