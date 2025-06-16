package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Building;
import pt.ipp.isep.dei.esoft.project.domain.Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository implements Serializable {
    Serialization serialization = new Serialization();

    private static final String FILE_PATH = "announcementRepository.ser";
    List<Announcement> announcements = new ArrayList<>();

    public void addAnnouncement(Announcement announcement) {
        if (validateAnnouncement(announcement)) {
            announcements.add(announcement);
        }
    }

    public boolean validateAnnouncement(Announcement announcement) {
        if (announcements.contains(announcement)) {
            return false;
        } else {
            return true;
        }
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public Announcement getAnnouncementWithID(int ID){
        Announcement announcement = null;
        for (int i = 0; i < announcements.size(); i++) {
            if(announcements.get(i).getRequest().getProperty().getPropertyID() == ID){
                announcement = announcements.get(i);
            }

        }
        return announcement;
    }

    public boolean checkAnnouncementExists(int announcementID) {
        for (Announcement announcement : announcements) {
            if (announcement.getAnnouncementID() == announcementID) {
                return true;
            }
        }
        return false;
    }





    public void removeAnnouncement(Announcement announcement){
        announcements.remove(announcement);
    }

    // Serialization methods

    @SuppressWarnings("unchecked")
    public void saveRepository() {
        serialization.toWrite((List<Object>) (List<?>) announcements, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadAnnouncementRepository() {
        this.announcements = (List<Announcement>) (List<?>) serialization.toRead(FILE_PATH);
        Announcement.setCont(announcements.size());
    }






}
