package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void getId() {
        Role role = new Role("12345", "OWNER");

        assertEquals("12345", role.getRoleID());
    }

    @Test
    void setId() {
        Role role = new Role("12345", "OWNER");

        assertEquals("12345", role.getRoleID());
    }

    @Test
    void getDescription() {
        Role role = new Role("12345", "OWNER");

        assertEquals("OWNER", role.getRoleDescription());
    }

    @Test
    void setDescription() {
        Role role = new Role("12345", "OWNER");

        assertEquals("OWNER", role.getRoleDescription());
    }

    @Test
    void testToString() {
        Role role = new Role("12345", "OWNER");

        assertEquals("#12345 - OWNER", role.toString());
    }
}