package de.olexiy.spring.mypetclinic.repositories;

import de.olexiy.spring.mypetclinic.model.Pet;
import de.olexiy.spring.mypetclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Visit entities.
 * Provides data access operations for visit management.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    
    /**
     * Finds visits by pet.
     */
    List<Visit> findByPet(Pet pet);
    
    /**
     * Finds visits by pet ID.
     */
    List<Visit> findByPetId(Long petId);
    
    /**
     * Finds visits by date.
     */
    List<Visit> findByDate(LocalDate date);
    
    /**
     * Finds visits between two dates.
     */
    List<Visit> findByDateBetween(LocalDate startDate, LocalDate endDate);
    
    /**
     * Finds visits after a specific date.
     */
    List<Visit> findByDateAfter(LocalDate date);
    
    /**
     * Finds visits before a specific date.
     */
    List<Visit> findByDateBefore(LocalDate date);
    
    /**
     * Finds visits ordered by date (most recent first).
     */
    List<Visit> findAllByOrderByDateDesc();
    
    /**
     * Finds visits by pet ordered by date (most recent first).
     */
    List<Visit> findByPetOrderByDateDesc(Pet pet);
    
    /**
     * Finds visits by pet ID ordered by date (most recent first).
     */
    List<Visit> findByPetIdOrderByDateDesc(Long petId);
    
    /**
     * Finds visits containing specific text in description (case-insensitive).
     */
    List<Visit> findByDescriptionContainingIgnoreCase(String description);
    
    /**
     * Finds recent visits (last 30 days).
     */
    @Query("SELECT v FROM Visit v WHERE v.date >= :thirtyDaysAgo ORDER BY v.date DESC")
    List<Visit> findRecentVisits(@Param("thirtyDaysAgo") LocalDate thirtyDaysAgo);
    
    /**
     * Counts visits for a specific pet.
     */
    long countByPet(Pet pet);
    
    /**
     * Counts visits on a specific date.
     */
    long countByDate(LocalDate date);
}
