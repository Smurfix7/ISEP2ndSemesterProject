package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.IOException;

public class RegisterEmployeeController {
    private static final Repositories repositories = Repositories.getInstance();
    EmployeeRepository employeeRepository = repositories.getAgentRepository();
    AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    PersonRepository personRepository = repositories.getPersonRepository();
    private final AuthFacade authenticationFacade = new AuthFacade();
    private final SendEmail sendEmail = new SendEmail();

    /**
     * Register a new employee in the authentication repository, person repository, and authentication repository
     *
     * @param name
     * @param taxNumber
     * @param emailAddress
     * @param contactTelephoneNumber
     * @param street
     * @param city
     * @param district
     * @param state
     * @param zipCode
     * @param role
     * @param passportNumber
     * @param agency
     */
    public void registerEmployee(String name, String taxNumber, String emailAddress, String contactTelephoneNumber, String street, String city, String district, String state, String zipCode, Role role, PassportCard passportNumber, Agency agency, String password) throws IOException {
        Address address;

        if (street == null & city == null & district == null & state == null & zipCode == null) {
            address = new Address();
        } else if (street != null & city != null & district == "n" & state != null & zipCode != null) {
            address = new Address(street, city, state, zipCode);
        } else {
            address = new Address(street, city, district, state, zipCode);
        }

        Employee employee = new Employee(name, taxNumber, emailAddress, contactTelephoneNumber, address, role, passportNumber, agency);
        Person person = new Person(name, taxNumber, emailAddress, contactTelephoneNumber, address, role, passportNumber);

        personRepository.addPerson(person);

        if (person.getRole().getRoleDescription() == "AGENT") {
            employeeRepository.addAgent(employee);
        } else if (person.getRole().getRoleDescription() == "STORE_MANAGER") {
            employeeRepository.addStoreManager(employee);
        } else if (person.getRole().getRoleDescription() == "NETWORK_MANAGER") {
            employeeRepository.addNetworkManager(employee);
        }

        authenticationRepository.addUserWithRole(name, emailAddress, password, role.getRoleDescription());
    }

    public String sendEmail(String justification) {
        String result;
        try {
            sendEmail.sendEmail(justification);
            result = "Email Sent!";
        } catch (IOException e) {
            result = "Email Not Sent!";
        }
        return result;
    }

    /**
     * Create password
     *
     * @return password
     */

    public String createPassword() {
        String password = Utils.generatePassword();
        return password;
    }

    /**
     * Returns if the user already exists.
     *
     * @param taxNumber
     * @return if user exists
     */
    public boolean checkIfUserExists(String taxNumber) {
        return authenticationFacade.existsUser(taxNumber);
    }
}
