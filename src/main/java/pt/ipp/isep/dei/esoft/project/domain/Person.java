package pt.ipp.isep.dei.esoft.project.domain;

import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.io.Serializable;

public class Person implements Serializable {
    // ATTRIBUTES
    private String name;
    private String taxNumber;
    private String emailAddress;
    private String telephoneNumber;
    private Address address;
    private Role role;
    private PassportCard passportCard;

    private final String NAME_BY_DEFAULT = "[NO NAME]";
    private final String TAX_NUMBER_BY_DEFAULT = "[NO TAX NUMBER]";
    private final String EMAIL_ADDRESS_BY_DEFAULT = "[NO EMAIL]";
    private final String TELEPHONE_NUMBER_BY_DEFAULT = "[NO CONTACT TELEPHONE NUMBER]";
    private final Address ADDRESS_BY_DEFAULT = null;
    private final Role ROLE_BY_DEFAULT = null;
    private final PassportCard PASSPORT_CARD_BY_DEFAULT = null;

    // CONSTRUCTORS
    /**
     * This method creates the Person object with default attributes
     */
    public Person(){
        this.name = NAME_BY_DEFAULT;
        this.taxNumber = TAX_NUMBER_BY_DEFAULT;
        this.emailAddress = EMAIL_ADDRESS_BY_DEFAULT;
        this.telephoneNumber = TELEPHONE_NUMBER_BY_DEFAULT;
        this.address = ADDRESS_BY_DEFAULT;
        this.role = ROLE_BY_DEFAULT;
        this.passportCard = PASSPORT_CARD_BY_DEFAULT;
    }

    /**
     *
     * This method creates the Person object
     *
     * @param name
     * @param taxNumber
     * @param emailAddress
     * @param telephoneNumber
     * @param address
     * @param role
     */
    public Person(String name, String taxNumber, String emailAddress, String telephoneNumber, Address address, Role role, PassportCard passportCard){
        this.name = name;
        this.taxNumber = taxNumber;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.address = new Address(address);
        this.role = new Role(role);
        this.passportCard = new PassportCard(passportCard);
    }

    /**
     *
     * This method creates the Person object
     *
     * @param name
     * @param taxNumber
     * @param emailAddress
     * @param telephoneNumber
     * @param role
     */
    public Person(String name, String taxNumber, String emailAddress, String telephoneNumber, Role role, PassportCard passportCard){
        this.name = name;
        this.taxNumber = taxNumber;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.address = ADDRESS_BY_DEFAULT;
        this.role = new Role(role);
        this.passportCard = new PassportCard(passportCard);
    }

    // SETS AND GETS

    /**
     *  This method returns the name of the Person
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *  This method changes the street of the Address
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  This method returns the taxNumber of the Person
     *
     * @return
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     *  This method changes the street of the Address
     * @param taxNumber
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     *  This method returns the emailAddress of the Person
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *  This method changes the street of the Address
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *  This method returns the telephoneNumber of the Person
     *
     * @return
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     *  This method changes the street of the Address
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     *  This method returns the address of the Person
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     *  This method changes the street of the Address
     * @param address
     */
    public void setAddress(Address address) {
        this.address = new Address(address);
    }

    /**
     *  This method returns the role of the Person
     *
     * @return
     */
    public Role getRole() {
        return role;
    }

    /**
     *  This method changes the street of the Address
     * @param role
     */
    public void setRole(Role role) {
        this.role = new Role(role);
    }

    /**
     *  This method returns the passportCard of the Person
     *
     * @return
     */
    public PassportCard getPassportCard() {
        return passportCard;
    }

    /**
     *  This method changes the street of the Address
     * @param passportCard
     */
    public void setPassportCard(PassportCard passportCard) {
        this.passportCard = new PassportCard(passportCard);
    }
    // TOSTRING

    /**
     * This method returns the characteristics of the Person
     *
     * @return
     */


    @Override
    public String toString() {
        return name+" | Tax Number: "+taxNumber+" | Email Address: "+emailAddress+" | Telephone Number: "+telephoneNumber+" | "+address+" | "+role+" | "+passportCard;
    }
}

