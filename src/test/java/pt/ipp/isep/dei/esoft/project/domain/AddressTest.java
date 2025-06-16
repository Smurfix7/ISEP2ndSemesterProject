package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void getStreet() {
        Address address = new Address();
        address.setStreet("Lt Jenkins");

        assertEquals("Lt Jenkins", address.getStreet());
    }

    @Test
    void setStreet() {
        Address address = new Address();
        address.setStreet("Lt Jenkins");

        assertEquals("Lt Jenkins", address.getStreet());
    }

    @Test
    void getCity() {
        Address address = new Address();
        address.setCity("Huston");

        assertEquals("Huston", address.getCity());
    }

    @Test
    void setCity() {
        Address address = new Address();
        address.setCity("Huston");

        assertEquals("Huston", address.getCity());
    }

    @Test
    void getState() {
        Address address = new Address();
        address.setState("TX");

        assertEquals("TX", address.getState());
    }

    @Test
    void setState() {
        Address address = new Address();
        address.setState("TX");

        assertEquals("TX", address.getState());
    }

    @Test
    void getZipCode() {
        Address address = new Address();
        address.setZipCode("423-423");

        assertEquals("432-423", address.getZipCode());
    }

    @Test
    void setZipCode() {
        Address address = new Address();
        address.setZipCode("423-423");

        assertEquals("432-423", address.getZipCode());
    }

    @Test
    void testToString() {
        Address address = new Address("Lt Jenkins","Huston","Texas","423-423");

        assertEquals("Address: Lt Jenkins, Huston, Texas, 423-423", address.toString());
    }
}