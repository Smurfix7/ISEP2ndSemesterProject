package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitRequestTest {

    @Test
    void setUser() {
        VisitRequest visitRequest = new VisitRequest();
        User user1 = new User("José","user@this.app","password","919-919-1919");
        visitRequest.setUser(user1);

        assertEquals(user1, visitRequest.getUser());
    }

    @Test
    void getUser() {
        VisitRequest visitRequest = new VisitRequest();
        User user1 = new User("José","user@this.app","password","919-919-1919");
        visitRequest.setUser(user1);

        assertEquals(user1, visitRequest.getUser());
    }

//    @Test
//    void setProperty() {
//        VisitRequest visitRequest = new VisitRequest();
//        Property property1 = new Property();
//        visitRequest.setAnnouncement(property1);
//
//        assertEquals(property1, visitRequest.getAnnouncement());
//    }
//
//    @Test
//    void getProperty() {
//        VisitRequest visitRequest = new VisitRequest();
//        Property property1 = new Property();
//        visitRequest.setAnnouncement(property1);
//
//        assertEquals(property1, visitRequest.getAnnouncement());
//    }

    @Test
    void setDate() {
        VisitRequest visitRequest = new VisitRequest();
        visitRequest.setDate("22/01/2029");

        assertEquals("22/01/2029", visitRequest.getDate());
    }

    @Test
    void getDate() {
        VisitRequest visitRequest = new VisitRequest();
        visitRequest.setDate("22/01/2029");

        assertEquals("22/01/2029", visitRequest.getDate());
    }

    @Test
    void setTimeFrame() {
        VisitRequest visitRequest = new VisitRequest();
        visitRequest.setTimeFrame("09AM-3PM");

        assertEquals("09AM-3PM", visitRequest.getTimeFrame());
    }

    @Test
    void getTimeFrame() {
        VisitRequest visitRequest = new VisitRequest();
        visitRequest.setTimeFrame("09AM-3PM");

        assertEquals("09AM-3PM", visitRequest.getTimeFrame());
    }

//    @Test
//    void testToString() {
//        VisitRequest visitRequest = new VisitRequest();
//        User user1 = new User("José","user@this.app","password","919-919-1919");
//        visitRequest.setUser(user1);
//        Property property1 = new Property();
//        visitRequest.setAnnouncement(property1);
//        visitRequest.setTimeFrame("09AM-3PM");
//        visitRequest.setDate("22/01/2029");
//
//        assertEquals("|Visit Request| Name: José | Telephone Number : 919-919-1919 | Date: 22/01/2029 | Time Frame: 09AM-3PM", visitRequest.toString());
//    }

    @Test
    void testSetUser() {
    }

    @Test
    void testGetUser() {
    }

    @Test
    void testSetProperty() {
    }

    @Test
    void testGetProperty() {
    }

    @Test
    void testSetDate() {
    }

    @Test
    void testGetDate() {
    }

    @Test
    void testSetTimeFrame() {
    }

    @Test
    void testGetTimeFrame() {
    }

    @Test
    void testToString1() {
    }
}