package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class PassportCard implements Serializable {

    // ATTRIBUTES

    private String passportNumber;
    private final String PASSPORT_NUMBER_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    /**
     * This method creates the PassportCard object with default attributes
     */
    public PassportCard() {
        this.passportNumber = PASSPORT_NUMBER_BY_DEFAULT;
    }

    /**
     * This method creates the PassportCard object duplicating an already existing one.
     *
     * @param passportCard
     */
    public PassportCard(PassportCard passportCard) {
        this.passportNumber = passportCard.getPassportNumber();
    }

    /**
     * This method creates the PassportCard object
     *
     * @param passportNumber
     */
    public PassportCard(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    // SETS AND GETS

    /**
     * This method returns the passportNumber of the PassportCard
     *
     * @return
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * This method changes the passportNumber of the PassportCard
     *
     * @param passportNumber
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the PassportCard
     *
     * @return
     */
    @Override
    public String toString() {
        return "Passport Card Number: " + passportNumber;
    }
}
