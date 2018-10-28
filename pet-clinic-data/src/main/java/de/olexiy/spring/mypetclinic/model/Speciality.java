package de.olexiy.spring.mypetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by olsak on Okt, 2018
 **/
@Entity
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
