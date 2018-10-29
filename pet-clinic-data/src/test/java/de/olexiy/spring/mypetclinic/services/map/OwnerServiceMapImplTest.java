package de.olexiy.spring.mypetclinic.services.map;

import de.olexiy.spring.mypetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by olsak on Okt, 2018
 **/
class OwnerServiceMapImplTest {

    private OwnerServiceMapImpl ownerService;
    private Long ownerId = 1L;
    private String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMapImpl(new PetServiceMapImpl(), new PetTypeServiceMapImp());
        ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerService.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void findById() {
        Owner byID = ownerService.findByID(ownerId);
        assertEquals(ownerId, byID.getId());
    }

    @Test
    void saveExistingId() {
        Long someId = 2L;
        Owner owner2 = Owner.builder().id(someId).build();
        Owner savedOwner = ownerService.save(owner2);
        assertEquals(someId, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwwner = ownerService.save(Owner.builder().build());
        assertNotNull(savedOwwner);
        assertNotNull(savedOwwner.getId());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(lastName, smith.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner foo = ownerService.findByLastName("foo");
        assertNull(foo);
    }
}