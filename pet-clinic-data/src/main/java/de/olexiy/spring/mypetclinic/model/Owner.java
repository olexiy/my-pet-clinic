package de.olexiy.spring.mypetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class Owner extends Person {

    private Set<Pet> pets = new HashSet<>();
    private String address;
    private String city;
    private String telephone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
