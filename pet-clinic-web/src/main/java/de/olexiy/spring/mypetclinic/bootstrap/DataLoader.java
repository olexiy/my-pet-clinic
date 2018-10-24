package de.olexiy.spring.mypetclinic.bootstrap;

import de.olexiy.spring.mypetclinic.model.*;
import de.olexiy.spring.mypetclinic.services.OwnerService;
import de.olexiy.spring.mypetclinic.services.PetTypeService;
import de.olexiy.spring.mypetclinic.services.SpeciaalitiesService;
import de.olexiy.spring.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Olexiy Sokurenko on Okt, 2018
 **/
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpeciaalitiesService speciaalitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpeciaalitiesService speciaalitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.speciaalitiesService = speciaalitiesService;
    }

    @Override
    public void run(String... args) {

        int count = speciaalitiesService.findAll().size();
        if (count == 0) {
            loadData();
        }


    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("cat");
        cat = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        dog = petTypeService.save(dog);

        Speciality radiologie = new Speciality();
        radiologie.setDescription("Radiologie");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        speciaalitiesService.save(radiologie);
        speciaalitiesService.save(surgery);
        speciaalitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 West");
        owner1.setCity("Munich");
        owner1.setTelephone("555-12345");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosko");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("3213 West");
        owner2.setCity("Munich");
        owner2.setTelephone("555-54321");


        Pet fionasCat = new Pet();
        fionasCat.setPetType(cat);
        fionasCat.setOwner(owner2);
        fionasCat.setName("Margo");
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiologie);
        vet1.getSpecialities().add(surgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet1.getSpecialities().add(dentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }


}
