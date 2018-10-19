package de.olexiy.spring.mypetclinic.bootstrap;

import de.olexiy.spring.mypetclinic.model.Owner;
import de.olexiy.spring.mypetclinic.model.Vet;
import de.olexiy.spring.mypetclinic.services.OwnerService;
import de.olexiy.spring.mypetclinic.services.VetService;
import de.olexiy.spring.mypetclinic.services.map.OwnerServiceMapImpl;
import de.olexiy.spring.mypetclinic.services.map.VetServiceMapImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMapImpl();
        vetService = new VetServiceMapImpl();
    }

    @Override
    public void run(String... args) {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet1);

        System.out.println("Loaded Vets....");

    }


}
