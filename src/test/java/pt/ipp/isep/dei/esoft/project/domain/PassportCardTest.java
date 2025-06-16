package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportCardTest {

    @Test
    void getPassportNumber() {
        PassportCard passportCard = new PassportCard();
        passportCard.setPassportNumber("123456789");

        assertEquals("123456789", passportCard.getPassportNumber());
    }

    @Test
    void setPassportNumber() {
        PassportCard passportCard = new PassportCard();
        passportCard.setPassportNumber("123456789");

        assertEquals("123456789", passportCard.getPassportNumber());
    }

    @Test
    void testToString() {
        PassportCard passportCard = new PassportCard();
        passportCard.setPassportNumber("123456789");

        assertEquals("Passport Card Number: 123456789", passportCard.toString());
    }
}