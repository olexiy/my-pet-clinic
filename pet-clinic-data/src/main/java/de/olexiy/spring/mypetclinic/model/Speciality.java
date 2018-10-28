package de.olexiy.spring.mypetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by olsak on Okt, 2018
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
}
