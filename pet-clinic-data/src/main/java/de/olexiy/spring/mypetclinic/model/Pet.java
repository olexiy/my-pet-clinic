package de.olexiy.spring.mypetclinic.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entity representing a pet.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"owner", "visits"})
@ToString(callSuper = true, exclude = {"owner", "visits"})
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    
    @NotBlank(message = "Pet name is required")
    @Size(min = 1, max = 30, message = "Pet name must be between 1 and 30 characters")
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @NotNull(message = "Pet type is required")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private PetType petType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @PastOrPresent(message = "Birth date cannot be in the future")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private List<Visit> visits = new ArrayList<>();

    /**
     * Adds a visit to this pet.
     */
    public void addVisit(Visit visit) {
        if (visit != null) {
            visits.add(visit);
            visit.setPet(this);
        }
    }

    /**
     * Removes a visit from this pet.
     */
    public void removeVisit(Visit visit) {
        if (visit != null) {
            visits.remove(visit);
            visit.setPet(null);
        }
    }

    /**
     * Returns an unmodifiable view of the visits.
     */
    public List<Visit> getVisits() {
        return Collections.unmodifiableList(visits);
    }

    /**
     * Calculates the age of the pet in years.
     */
    public int getAge() {
        if (birthDate == null) {
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    /**
     * Returns true if the pet is a puppy (less than 1 year old).
     */
    public boolean isPuppy() {
        return getAge() < 1;
    }
}
