package de.olexiy.spring.mypetclinic.services.map;

import de.olexiy.spring.mypetclinic.model.Pet;
import de.olexiy.spring.mypetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}