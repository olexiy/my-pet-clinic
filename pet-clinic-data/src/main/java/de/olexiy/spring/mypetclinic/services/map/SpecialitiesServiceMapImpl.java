package de.olexiy.spring.mypetclinic.services.map;

import de.olexiy.spring.mypetclinic.model.Speciality;
import de.olexiy.spring.mypetclinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * Created by olsak on Okt, 2018
 **/
@Service
@Profile({"default", "map"})
public class SpecialitiesServiceMapImpl extends AbstractMapService<Speciality, Long> implements SpecialitiesService {


    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findByID(id);
    }
}
