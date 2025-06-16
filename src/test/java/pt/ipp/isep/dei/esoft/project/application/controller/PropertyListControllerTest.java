package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.SelectedParameters;

import static org.junit.jupiter.api.Assertions.*;

class PropertyListControllerTest {

    /**
     * Tests if its possible to create an SelectedParameters object through the createSelectedParameters method.
     */
    @Test
    void createSelectedParameters() {
        PropertyListController controller = new PropertyListController();
        String businessType = "renting";
        String propertyType = "house";
        int numberRooms = 2;
        SelectedParameters test = new SelectedParameters(businessType, propertyType, numberRooms);

        assertEquals(test,controller.createSelectedParameters(businessType,propertyType,numberRooms));
    }
}