package de.olexiy.spring.mypetclinic.model;

/**
 * Created by olsak on Okt, 2018
 **/
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
