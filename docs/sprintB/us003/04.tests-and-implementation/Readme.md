# US 003 - To register a new employee

# 4. Tests 

**Test 1:** Check that it is not possible to register an employee . ( TO BE DONE ) 

    @Test
    void registerEmployee() {
    }

**Test 2:** Check that it is not possible to display agency list. ( TO BE DONE )

    @Test
    void displayAgencies() {
    }

**Test 3:** Check that it is not possible to display the role list. ( TO BE DONE )

    @Test
    void displayRoles() {
    }


# 5. Construction (Implementation)


## Class RegisterEmployeeController

```java
public class RegisterEmployeeController {

    public void RegisterEmployee(String name, PassportCard passportNumber, String emailAdress, int taxNumber, int contactTelephoneNumber, String street, String city, String district, String state, String zipCode, Role role, Agency agency) {
        Address address = new Address(street, city, district, state, zipCode);
        Agent employee = new Agent(name, passportNumber, emailAdress, taxNumber, contactTelephoneNumber, address, role, agency);

        PersonRepository.addAgent(employee);
        AgentRepository.addAgent(employee);
    }

    public void displayAgencies() {}

    public void displayRoles() {}

}
```

# 6. Integration and Demo 

* None at the moment.


# 7. Observations

The display varies depending on format in which is presented (console / visual).





