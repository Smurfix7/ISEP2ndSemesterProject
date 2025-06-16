package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectedParametersTest {

    @Test
    void getBusinessType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setBusinessType("test");
        assertEquals("test",selectedParameters.getBusinessType());
    }

    @Test
    void setBusinessType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setBusinessType("test");
        assertEquals("test",selectedParameters.getBusinessType());
    }

    @Test
    void getPropertyType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPropertyType("test");
        assertEquals("test",selectedParameters.getPropertyType());
    }

    @Test
    void setPropertyType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPropertyType("test");
        assertEquals("test",selectedParameters.getPropertyType());
    }

    @Test
    void getNumberRooms() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setNumberRooms(20);
        assertEquals(20,selectedParameters.getNumberRooms());
    }

    @Test
    void setNumberRooms() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setNumberRooms(20);
        assertEquals(20,selectedParameters.getNumberRooms());
    }

    @Test
    void getPriceSorting() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPriceSorting("Ascending");
        assertEquals("Ascending",selectedParameters.getPriceSorting());
    }

    @Test
    void setPriceSorting() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPriceSorting("Ascending");
        assertEquals("Ascending",selectedParameters.getPriceSorting());
    }

//    @Test
//    void getAddress() {
//        SelectedParameters selectedParameters = new SelectedParameters();
//
//        Address ad1 = new Address("a","d","r","1");
//        selectedParameters.setAddress("a","d","r","1");
//        assertEquals(ad1,selectedParameters.getAddress());
//    }

//    @Test
//    void setAddress() {
//        SelectedParameters selectedParameters = new SelectedParameters();
//
//        Address ad1 = new Address("a","d","r","1");
//        selectedParameters.setAddress("a","d","r","1");
//        assertEquals(ad1,selectedParameters.getAddress());
//    }
}