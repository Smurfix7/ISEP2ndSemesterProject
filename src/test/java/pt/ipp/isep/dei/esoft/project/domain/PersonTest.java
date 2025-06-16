package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void getTaxNumber() {
        Person person = new Person();
        person.setTaxNumber("123-456-2378");

        assertEquals("123-456-2378", person.getTaxNumber());
    }

    @Test
    void setTaxNumber() {
        Person person = new Person();
        person.setTaxNumber("123-456-7832");

        assertEquals("123-456-7832", person.getTaxNumber());
    }

    @Test
    void getAddress() {
        Person person = new Person();
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        person.setAddress(address);
        assertEquals("Address: Lt Jenkins, Huston, Texas, 23423", person.getAddress().toString());
    }

    @Test
    void setAddress() {
        Person person = new Person();
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        person.setAddress(address);
        assertEquals("Address: Lt Jenkins, Huston, Texas, 23423", person.getAddress().toString());
    }

    @Test
    void getRole() {
        Person person = new Person();
        Role role = new Role("123456", "Manager");
        person.setRole(role);
        assertEquals("#123456 - Manager", person.getRole().toString());
    }

    @Test
    void setRole() {
        Person person = new Person();
        Role role = new Role("123456", "Manager");
        person.setRole(role);
        assertEquals("#123456 - Manager", person.getRole().toString());
    }

    @Test
    void getPassportCard(){
        Person person = new Person();
        PassportCard passportCard = new PassportCard("123456");
        person.setPassportCard(passportCard);
        assertEquals("Passport Card Number: 123456", person.getPassportCard().toString());
    }

    @Test
    void setPassportCard(){
        Person person = new Person();
        PassportCard passportCard = new PassportCard("123456");
        person.setPassportCard(passportCard);
        assertEquals("Passport Card Number: 123456", person.getPassportCard().toString());
    }

    @Test
    void testToString() {
        PassportCard passportCard = new PassportCard("123456");
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role = new Role("123456","Manager");
        Person person = new Person("Pedro", "123-456-2378", "dummy@domain.com", "999-555-2222",address,role,passportCard);

        assertEquals("Pedro | Tax Number: 123-456-2378 | Email Address: dummy@domain.com | Telephone Number: 999-555-2222 | Address: Lt Jenkins, Huston, Texas, 23423 | Manager - 123456 | Passport Card Number: 123456", person.toString());
    }
}