package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {

    @Test
    void getAgencyID() {
        Agency agency = new Agency();
        agency.setAgencyID("Era Imobiliaria");

        assertEquals("Era Imobiliaria", agency.getAgencyID());
    }

    @Test
    void setAgencyID() {
        Agency agency = new Agency();
        agency.setAgencyID("01");

        assertEquals("01", agency.getAgencyID());
    }

    @Test
    void getAgencyName() {
        Agency agency = new Agency();
        agency.setAgencyName("Era");

        assertEquals("Era", agency.getAgencyName());
    }

    @Test
    void setAgencyName() {
        Agency agency = new Agency();
        agency.setAgencyName("Era");

        assertEquals("Era", agency.getAgencyName());
    }

    @Test
    void getEmailAddress() {
        Agency agency = new Agency();
        agency.setEmailAddress("Era@gmail.com");

        assertEquals("Era@gmail.com", agency.getContactTelephoneNumber());
    }

    @Test
    void setEmailAddress() {
        Agency agency = new Agency();
        agency.setEmailAddress("Era@gmail.com");

        assertEquals("Era@gmail.com", agency.getContactTelephoneNumber());
    }

    @Test
    void getTelephoneNumber() {
        Agency agency = new Agency();
        agency.setContactTelephoneNumber("123-123-1234");

        assertEquals("123-123-1234", agency.getContactTelephoneNumber());
    }

    @Test
    void setTelephoneNumber() {
        Agency agency = new Agency();
        agency.setContactTelephoneNumber("123-123-1234");

        assertEquals("123-123-1234", agency.getContactTelephoneNumber());
    }

    @Test
    void getAddress() {
        Agency agency = new Agency();
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "234-23-1234");
        agency.setAddress(address);
        assertEquals("Address: Lt Jenkins, Huston, Texas, 234-23-1234", agency.getAddress());
    }

    @Test
    void setAddress() {
        Agency agency = new Agency();
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "234-23-1234");
        agency.setAddress(address);
        assertEquals("Address: Lt Jenkins, Huston, Texas,  234-23-1234", agency.getAddress());
    }

    @Test
    void testToString() {
        Address address = new Address("Lt Jenkins", "Huston", "Texas",  "234-23-1234");
        Agency agency = new Agency("Era","111","Era@gmail.com","123-123-1234", address);

        assertEquals("Agency ID: 01 | Agency Name: Era | Email Address: Era@gmail.com | Telephone Number: 123-123-1234 | Address: Lt Jenkins, Huston, Texas, TX, 234-23-1234", agency.toString());
    }
}