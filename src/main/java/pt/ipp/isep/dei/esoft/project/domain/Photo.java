package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class Photo implements Serializable {

    // ATTRIBUTES


    private int photoID;

    private String photoURI;

    private final int PHOTO_ID_BY_DEFAULT = 0;

    private int count=PHOTO_ID_BY_DEFAULT;
    private final String PATH_TO_PNG_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    /**
     * This method creates the Photo object with default attributes
     */
    public Photo(){
        count++;
        this.photoID = count;
        this.photoURI = PATH_TO_PNG_BY_DEFAULT;
    }

    /**
     *
     * @param photoURI
     */
    public Photo(String photoURI){
        count++;
        this.photoID = count;
        this.photoURI = photoURI;
    }

    // SETS AND GETS
    /**
     *  This method returns the photoID of the Photo
     *
     * @return
     */
    public int getPhotoID() {
        return photoID;
    }

    /**
     *  This method changes the photoID of the Photo
     * @param photoID
     */
    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    /**
     *  This method returns the photoURL of the Photo
     *
     * @return
     */
    public String getPhotoURI() {
        return photoURI;

    }

    /**
     *  This method changes the photoURI of the Photo
     * @param photoURI
     */
    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the Photo
     *
     * @return
     */
    @Override
    public String toString() {
        return " | PhotoID: "+photoID+" | Path To PNG: "+ photoURI;
    }
}
