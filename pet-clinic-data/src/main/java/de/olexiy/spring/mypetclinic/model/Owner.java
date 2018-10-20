package de.olexiy.spring.mypetclinic.model;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
