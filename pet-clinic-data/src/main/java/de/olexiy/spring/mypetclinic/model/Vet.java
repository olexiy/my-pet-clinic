package de.olexiy.spring.mypetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
