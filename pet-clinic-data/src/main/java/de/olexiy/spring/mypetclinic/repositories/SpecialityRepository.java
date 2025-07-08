package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Speciality entities.
 * Provides data access operations for veterinary speciality management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    
    /**
     * Finds a speciality by description (case-insensitive).
     */
    Optional<Speciality> findByDescriptionIgnoreCase(String description);
    
    /**
     * Finds specialities whose description contains the given string (case-insensitive).
     */
    List<Speciality> findByDescriptionContainingIgnoreCase(String description);
    
    /**
     * Finds all specialities ordered by description.
     */
    List<Speciality> findAllByOrderByDescriptionAsc();
    
    /**
     * Checks if a speciality exists with the given description.
     */
    boolean existsByDescriptionIgnoreCase(String description);
}
