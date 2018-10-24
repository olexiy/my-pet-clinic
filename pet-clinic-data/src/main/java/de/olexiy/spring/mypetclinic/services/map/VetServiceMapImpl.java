package de.olexiy.spring.mypetclinic.services.map;

import de.olexiy.spring.mypetclinic.model.Vet;
import de.olexiy.spring.mypetclinic.services.SpeciaalitiesService;
import de.olexiy.spring.mypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {
    private final SpeciaalitiesService speciaalitiesService;

    public VetServiceMapImpl(SpeciaalitiesService speciaalitiesService) {
        this.speciaalitiesService = speciaalitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    speciaalitiesService.save(speciality);
                }
            });
        }

        return super.save(vet);
    }
}
