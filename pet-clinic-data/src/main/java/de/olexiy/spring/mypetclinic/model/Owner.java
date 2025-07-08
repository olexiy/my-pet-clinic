package de.olexiy.spring.mypetclinic.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing a pet owner.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "pets")
@ToString(callSuper = true, exclude = "pets")
@Entity
@Table(name = "owners")
public class Owner extends Person {
    
    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @Column(name = "address", nullable = false)
    private String address;
    
    @NotBlank(message = "City is required")
    @Size(max = 80, message = "City cannot exceed 80 characters")
    @Column(name = "city", nullable = false, length = 80)
    private String city;
    
    @NotBlank(message = "Telephone is required")
    @Pattern(regexp = "^[0-9\\-\\+\\s\\(\\)]{10,20}$", message = "Invalid telephone number format")
    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, List<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if (pets != null) {
            this.pets = new ArrayList<>(pets);
        }
    }

    /**
     * Adds a pet to this owner.
     */
    public void addPet(Pet pet) {
        if (pet != null) {
            pets.add(pet);
            pet.setOwner(this);
        }
    }

    /**
     * Removes a pet from this owner.
     */
    public void removePet(Pet pet) {
        if (pet != null) {
            pets.remove(pet);
            pet.setOwner(null);
        }
    }

    /**
     * Returns a pet by name, or null if not found.
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Returns a pet by name with option to ignore case.
     */
    public Pet getPet(String name, boolean ignoreNew) {
        if (name == null) {
            return null;
        }
        
        return pets.stream()
                .filter(pet -> !ignoreNew || !pet.isNew())
                .filter(pet -> name.equalsIgnoreCase(pet.getName()))
                .findFirst()
                .orElse(null);
    }
}
