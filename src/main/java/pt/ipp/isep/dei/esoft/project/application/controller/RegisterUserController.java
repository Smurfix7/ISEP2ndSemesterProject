package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.PersonRepository;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

public class RegisterUserController {
    private AuthFacade authenticationFacade = new AuthFacade();

    /**
     * Creates a Person object and saves it in the PersonRepository
     * @param name
     * @param taxNumber
     * @param emailAddress
     * @param telephoneNumber
     * @param address
     * @param passport
     * @param role
     */
    public boolean createPerson(String name, String taxNumber, String emailAddress, String telephoneNumber, Address address, PassportCard passport, Role role){
        Person person = new Person(name, taxNumber, emailAddress, telephoneNumber, address, role, passport);
        return PersonRepository.addPerson(person);
    }

    /**
     * Saves a new User in the AuthenticationRepository and returns the operation success.
     *
     * @param name
     * @param emailAddress
     * @param password
     * @return boolean
     */
    public boolean createUser (String name, String emailAddress, String password){
        return AuthenticationRepository.addUserWithRole(name,emailAddress,password, AuthenticationController.ROLE_USER);
    }

    public boolean checkUserExists (String email){
        return authenticationFacade.existsUser(email);
    }
}
