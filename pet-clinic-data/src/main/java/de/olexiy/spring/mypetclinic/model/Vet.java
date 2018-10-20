package de.olexiy.spring.mypetclinic.model;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
