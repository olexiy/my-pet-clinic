package de.olexiy.spring.mypetclinic.model;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
