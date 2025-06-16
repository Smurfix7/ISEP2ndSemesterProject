package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyIDTest {

    @Test
    void getPropertyID() {
        Property property = new Property();
        Property property2 = new Property();
        Property property3 = new Property();

        System.out.println(property.getPropertyID());
        System.out.println(property2.getPropertyID());
        System.out.println(property3.getPropertyID());
    }
}