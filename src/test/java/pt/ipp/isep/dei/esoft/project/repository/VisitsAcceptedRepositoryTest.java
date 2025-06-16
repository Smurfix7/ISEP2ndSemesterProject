package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class VisitsAcceptedRepositoryTest {
    static List<VisitRequest> visitsAccepted = new ArrayList<>();
    @Test
    void getVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsAccepted.add(visitRequest);
        assertEquals(visitRequest, visitsAccepted.get(0));
    }

    @Test
    void addVisitAccepted() {

            VisitRequest visitRequest = new VisitRequest();
            visitsAccepted.add(visitRequest);
            assertEquals(visitRequest, visitsAccepted.get(0));

    }

    @Test
    void removeVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsAccepted.add(visitRequest);
        visitsAccepted.remove(visitRequest);

            assertTrue(visitsAccepted.contains(visitRequest));

    }

    @Test
    void testGetVisitAccepted() {

        VisitRequest visitRequest = new VisitRequest();
        visitsAccepted.add(visitRequest);
        assertEquals(visitRequest, visitsAccepted.get(0));

    }
}