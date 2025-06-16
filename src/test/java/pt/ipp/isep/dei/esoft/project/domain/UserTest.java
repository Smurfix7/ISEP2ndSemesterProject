package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getName() {
        User user = new User();
        user.setName("João");

        assertEquals("João", user.getName());
    }

    @Test
    void setName() {
        User user = new User();
        user.setName("João");

        assertEquals("João", user.getName());
    }

    @Test
    void getEmailAddress() {
        User user = new User();
        user.setEmailAddress("dummy@gmail.com");

        assertEquals("dummy@gmail.com", user.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        User user = new User();
        user.setEmailAddress("dummy@gmail.com");

        assertEquals("dummy@gmail.com", user.getEmailAddress());
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("password");

        assertEquals("password", user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("password");

        assertEquals("password", user.getPassword());
    }

    @Test
    void testToString() {
        User user = new User("John", "dummy@gmail.com", "password","E");

        assertEquals("|User| Name: John | Email Address: dummy@gmail.com | Password: password | Telephone Number: E", user.toString());
    }
}