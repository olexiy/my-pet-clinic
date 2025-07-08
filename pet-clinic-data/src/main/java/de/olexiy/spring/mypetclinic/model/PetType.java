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
 * Entity representing a type of pet (e.g., dog, cat, bird).
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
@Table(name = "types")
public class PetType extends BaseEntity {

    @NotBlank(message = "Pet type name is required")
    @Size(min = 1, max = 80, message = "Pet type name must be between 1 and 80 characters")
    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
