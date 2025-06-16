package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotoTest {

    @Test
    void getPhotoID() {
        Photo photo = new Photo();

        assertEquals(1, photo.getPhotoID());
    }

    @Test
    void getPathToPNG() {
        Photo photo = new Photo();
        photo.setPhotoURI("./images");

        assertEquals("./images", photo.getPhotoURI());
    }

    @Test
    void setPathToPNG() {
        Photo photo = new Photo();
        photo.setPhotoURI("./images");

        assertEquals("./images", photo.getPhotoURI());
    }

    @Test
    void testToString() {
        Photo photo = new Photo("./images");


        assertEquals(" | PhotoID: 1 | Path To PNG: ./images", photo.toString());
    }
}