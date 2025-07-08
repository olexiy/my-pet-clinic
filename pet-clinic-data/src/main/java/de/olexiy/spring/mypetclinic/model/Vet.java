package de.olexiy.spring.mypetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entity representing a veterinarian.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "specialities")
@ToString(callSuper = true, exclude = "specialities")
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    @Builder.Default
    private List<Speciality> specialities = new ArrayList<>();

    /**
     * Constructor with id and names.
     */
    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    /**
     * Adds a speciality to this vet.
     */
    public void addSpeciality(Speciality speciality) {
        if (speciality != null && !specialities.contains(speciality)) {
            specialities.add(speciality);
        }
    }

    /**
     * Removes a speciality from this vet.
     */
    public void removeSpeciality(Speciality speciality) {
        specialities.remove(speciality);
    }

    /**
     * Returns an unmodifiable view of the specialities.
     */
    public List<Speciality> getSpecialities() {
        return Collections.unmodifiableList(specialities);
    }

    /**
     * Returns the number of specialities.
     */
    public int getNrOfSpecialities() {
        return specialities.size();
    }

    /**
     * Returns true if this vet has the given speciality.
     */
    public boolean hasSpeciality(Speciality speciality) {
        return specialities.contains(speciality);
    }
}
