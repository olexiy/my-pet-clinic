package de.olexiy.spring.mypetclinic.services.map;

import de.olexiy.spring.mypetclinic.model.Visit;
import de.olexiy.spring.mypetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by olsak on Okt, 2018
 **/
@Service
@Profile({"default", "map"})
public class VisitServiceMapImpl extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null) {
            throw new IllegalStateException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
