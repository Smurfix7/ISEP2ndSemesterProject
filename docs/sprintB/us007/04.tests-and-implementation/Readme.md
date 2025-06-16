# US 007 - To Register in the System 

# 4. Tests 

**Test 1:** Checks if its possible to create a Person. (to be done)

	@Test
    void createPerson() {
        UserRegisterController controller = new UserRegisterController();
        String name= "F";
        int taxNumber=1;
        String emailAddress = "R";
        int telephoneNumber=9;
        Address ad1 = new Address();
        Role role = new Role();
        PassportCard passportCard = new PassportCard();
        
        controller.createPerson(name,taxNumber,emailAddress,telephoneNumber,ad1,passportCard,role);
        
        Person person = new Person(name,taxNumber,emailAddress,telephoneNumber,ad1,role,passportCard);
        
        assertEquals(PersonRepository.getPeople(0),person);
    }

**Test 2:** Checks if its possible to create an User. (to be done)

    @Test
    void createUser() {
        UserRegisterController controller = new UserRegisterController();
        String name= "F";
        String emailAddress = "R";
        String password = "D";

        controller.createUser(name,emailAddress,password);

        User user = new User(name,emailAddress,password);

        assertEquals(AuthenticationRepository.getUser(0),user);
    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class UserRegisterController 

```java
public class UserRegisterController {
    
    public void createPerson(String name, int taxNumber, String emailAddress, int telephoneNumber, Address address, PassportCard passport, Role role){
        Person person = new Person(name, taxNumber, emailAddress, telephoneNumber, address, role, passport);
        PersonRepository.addPerson(person);
    }

    public void createUser (String name, String emailAddress, String password){
        User user = new User(name,emailAddress,password);
        AuthenticationRepository.validateUser(user);
        AuthenticationRepository.addUser(user);
    }
    
}
```

# 6. Integration and Demo 

* None at the moment


# 7. Observations

The AuthenticationUI has a similar use as this US, so it's hard to differentiate between them.





