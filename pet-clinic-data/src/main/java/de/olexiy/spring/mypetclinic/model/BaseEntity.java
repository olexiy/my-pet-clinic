package de.olexiy.spring.mypetclinic.model;

import java.io.Serializable;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
