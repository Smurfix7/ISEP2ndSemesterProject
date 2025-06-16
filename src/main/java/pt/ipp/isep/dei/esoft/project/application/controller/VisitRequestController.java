package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRequestsRepository;

import java.util.List;

public class VisitRequestController {
    public Agency agency = new Agency();

    /**
     * Create a Visit Request and add to the repository
     * @param name
     * @param emailAddress
     * @param password
     * @param telephoneNumber
     * @param announcement
     * @param date
     * @param timeFrame
     * @return
     */
    public Object CreateVisitRequest(String name, String emailAddress, String password, String telephoneNumber, Announcement announcement, String date, String timeFrame) {
        VisitRequest visitRequest1 = new VisitRequest(name, emailAddress, password, telephoneNumber, announcement, date, timeFrame);
        VisitRequestsRepository.addVisitRequested(visitRequest1);
        return visitRequest1;
    }

    /**
     * Return a copy of the Announcements List
     * @return announcements
     */
    public List<Announcement> getCopyAnnouncementsList() {
        Repositories repositories = Repositories.getInstance();
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        return announcementRepository.getAnnouncements();
    }

    /**
     * Returns the announcement with the id
     * @param n
     * @return announcement
     */
    public Announcement getAnnouncementWithID(int n){
        Repositories repositories = Repositories.getInstance();
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        return announcementRepository.getAnnouncementWithID(n);}
}
