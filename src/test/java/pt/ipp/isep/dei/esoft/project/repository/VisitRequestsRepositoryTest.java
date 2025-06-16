package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitRequestsRepositoryTest {
    static List<VisitRequest> visitsRequested = new ArrayList<>();
    @Test
    void getVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        assertEquals(visitRequest, visitsRequested.get(0));
    }

    @Test
    void addVisitAccepted() {

        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        assertEquals(visitRequest, visitsRequested.get(0));

    }

    @Test
    void removeVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        visitsRequested.remove(visitRequest);

        assertTrue(visitsRequested.contains(visitRequest));

    }

    @Test
    void testGetVisitAccepted() {

        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        assertEquals(visitRequest, visitsRequested.get(0));

    }
}