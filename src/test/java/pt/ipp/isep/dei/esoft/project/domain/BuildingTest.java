package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBathrooms() {
        Building building = new Building();
        building.setBathrooms(1);
        assertEquals(1, building.getBathrooms());
    }

    @Test
    void setBathrooms() {
        Building building = new Building();
        building.setBathrooms(1);
        assertEquals(1, building.getBathrooms());
    }

    @Test
    void getBedrooms() {
        Building building = new Building();
        building.setBedrooms(1);
        assertEquals(1, building.getBedrooms());
    }

    @Test
    void setBedrooms() {
        Building building = new Building();
        building.setBedrooms(1);
        assertEquals(1, building.getBedrooms());
    }

    @Test
    void getParkingSpaces() {
        Building building = new Building();
        building.setParkingSpaces(1);
        assertEquals(1, building.getParkingSpaces());
    }

    @Test
    void setParkingSpaces() {
        Building building = new Building();
        building.setParkingSpaces(1);
        assertEquals(1, building.getParkingSpaces());
    }

    @Test
    void testToString() {
        Building building = new Building();


        String expected = "Building@<hashcode> | Bedrooms: 3 | Bathrooms: 2 | Parking Spaces: 1";
        assertEquals(expected, building.toString());
    }
}