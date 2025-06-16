package pt.ipp.isep.dei.esoft.project.domain;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.io.Serializable;
import java.util.Objects;


public class Employee extends Person implements Serializable {
    private String email;
    private Agency agency;
    private String network;
    private final Agency AGENCY_BY_DEFAULT = null;

    /**
     * This method creates the Agent object
     *
     * @param name
     * @param taxNumber
     * @param emailAddress
     * @param contactTelephoneNumber
     * @param address
     * @param role
     * @param passportNumber
     * @param agency
     */
    public Employee(String name, String taxNumber, String emailAddress, String contactTelephoneNumber, Address address, Role role, PassportCard passportNumber, Agency agency) {
        super(name, taxNumber, emailAddress, contactTelephoneNumber, address, role, passportNumber);
        this.agency = agency;
    }

    /**
     * This method creates the Employee object without Address
     */
    public Employee(String name, String taxNumber, String emailAddress, String contactTelephoneNumber, Role role, PassportCard passportNumber, Agency agency) {
        super(name, taxNumber, emailAddress, contactTelephoneNumber, role, passportNumber);
        this.agency = agency;
    }

    /**
     * This method creates the Employee object with default attributes
     */
    public Employee() {
        super();
        this.agency = AGENCY_BY_DEFAULT;
    }

    /**
     *  This method returns the agencyName of the Employee
     *
     * @return
     */
    public String getAgencyName() {
        return agency.getAgencyName();
    }

    /**
     *  This method returns the agency of the Employee
     *
     * @return
     */
    public Agency getAgency() {
        return agency;
    }


    /**
     *  This method changes Agency
     * @param agency
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * This method returns the characteristics of the Agent
     *
     * @return
     */
    @Override
    public String toString() {
        if(this.agency != null){
            return "Agent: "+ super.toString() +" | Agency ID: " + agency.getAgencyName();
        }else {
            return "No assigned agent";
        }
    }

    // TEMPLATE

    public Employee(String email) {
        this.email = email;
    }

    /**
     *
      * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }


    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Employee clone() {
        return new Employee(this.email);
    }
}
