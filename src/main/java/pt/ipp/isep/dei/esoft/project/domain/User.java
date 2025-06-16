package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class User implements Serializable {


    // ATTRIBUTES

    private String name;
    private String emailAddress;
    private String password;
    private String telephoneNumber;

    private final String NAME_BY_DEFAULT = "[NO DATA]";
    private final String EMAIL_ADDRESS_BY_DEFAULT = "[NO DATA]";
    private final String PASSWORD_BY_DEFAULT = "[NO DATA]";
    private final String TELEPHONE_NUMBER_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    /**
     * User Constructor with default atributes.
     */
    public User() {
        this.name = NAME_BY_DEFAULT;
        this.emailAddress = EMAIL_ADDRESS_BY_DEFAULT;
        this.password = PASSWORD_BY_DEFAULT;
        this.telephoneNumber = TELEPHONE_NUMBER_BY_DEFAULT;
    }

    /**
     * User Constructor with all the atributes.
     *
     * @param name
     * @param emailAddress
     * @param password
     * @param telephoneNumber
     */
    public User(String name, String emailAddress, String password, String telephoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
    }

    // SETS AND GETS

    /**
     * Return the name of a User.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Change the name of a User.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the email address of a User.
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Change the email of a User.
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Return the password of a User.
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Change the password of a User.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return the telephoneNumber of a User.
     *
     * @return
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Change the telephoneNumber of a User.
     *
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    // TOSTRING

    /**
     * Prints the User information.
     *
     * @return
     */
    @Override
    public String toString() {
        return "|User| Name: " + name + " | Email Address: " + emailAddress + " | Password: " + password + " | Telephone Number: " + telephoneNumber;
    }
}