package de.olexiy.spring.mypetclinic.services.map;

import de.olexiy.spring.mypetclinic.model.Owner;
import de.olexiy.spring.mypetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }
}