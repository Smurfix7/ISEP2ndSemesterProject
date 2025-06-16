package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.PersonRepository;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserControllerTest {

    @Test
    void createPerson() {
        RegisterUserController controller = new RegisterUserController();
        String name= "F";
        String taxNumber= "T";
        String emailAddress = "R";
        String telephoneNumber= "E";
        Address ad1 = new Address();
        Role role = new Role();
        PassportCard passportCard = new PassportCard();

        controller.createPerson(name,taxNumber,emailAddress,telephoneNumber,ad1,passportCard,role);

        Person person = new Person(name,taxNumber,emailAddress,telephoneNumber,ad1,role,passportCard);

        assertEquals(PersonRepository.getPeople(0),person);
    }

    @Test
    void createUser() {
        RegisterUserController controller = new RegisterUserController();
        String name= "F";
        String emailAddress = "R";
        String password = "D";

        controller.createUser(name,emailAddress,password);

       // User user = new User(name,emailAddress,password,telephoneNumber);

        // Conflito com a programação do template. Tenho permissão para alterar?
        //assertEquals(AuthenticationRepository.getUser(0),user);
    }
}