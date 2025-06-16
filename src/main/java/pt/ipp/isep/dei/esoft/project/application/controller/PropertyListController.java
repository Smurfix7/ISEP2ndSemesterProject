package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;


public class PropertyListController {

    Agency agency = new Agency();

    /**
     * This method creates a SelectedParameters object to be displayed
     *
     * @param businessType
     * @param propertyType
     * @param numberRooms
     */
    public SelectedParameters createSelectedParameters(String businessType, String propertyType, int numberRooms) {
        return new SelectedParameters(businessType, propertyType, numberRooms);
    }

    /**
     * Gets the LandList Copy created in the controller
     * @return List<Land>
     */
    public List<Announcement> getCopyAnnouncementList() {
        Repositories repositories = Repositories.getInstance();
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        return announcementRepository.getAnnouncements();
    }



}
