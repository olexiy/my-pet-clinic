package de.olexiy.spring.mypetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entity representing a veterinary speciality.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    @NotBlank(message = "Speciality description is required")
    @Size(min = 1, max = 80, message = "Speciality description must be between 1 and 80 characters")
    @Column(name = "description", nullable = false, unique = true, length = 80)
    private String description;

    @Override
    public String toString() {
        return description;
    }
}
