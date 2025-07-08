package de.olexiy.spring.mypetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

/**
 * Entity representing a visit to the veterinary clinic.
 * 
 * @author Olexiy Sokurenko
 * @since 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "pet")
@ToString(callSuper = true, exclude = "pet")
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @NotNull(message = "Visit date is required")
    @PastOrPresent(message = "Visit date cannot be in the future")
    @Column(name = "date", nullable = false)
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @NotBlank(message = "Visit description is required")
    @Size(min = 1, max = 255, message = "Visit description must be between 1 and 255 characters")
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Pet is required for a visit")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    /**
     * Constructor with pet and description (date defaults to today).
     */
    public Visit(Pet pet, String description) {
        this.pet = pet;
        this.description = description;
        this.date = LocalDate.now();
    }

    /**
     * Returns true if this visit occurred today.
     */
    public boolean isToday() {
        return LocalDate.now().equals(date);
    }

    /**
     * Returns true if this visit is in the past.
     */
    public boolean isPast() {
        return date != null && date.isBefore(LocalDate.now());
    }
}
