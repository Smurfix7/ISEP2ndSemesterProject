# US 018 - To Register in the System 

# 4. Tests 


**Test 1:** This test checks the B output (To be Done)

```java
    @Test
    void getB() {
    }
```
**Test 2:** This test checks the forecastlist output (To be Done)

```java
    @Test
    void getForecastList() {
    }
```
**Test 3:** This test checks the toString method (To be Done)

```java
    @Test
    void testToString() {
    }
```
**Test 4:** This test checks the anova significance model (To be done)

```java
    @Test
    void anovaSingificanceModel() {
    }

```
**Test 5:** This test checks the coefficient intervals (to be done)

```java
    @Test
    void calculateCoefficientCondifenceIntervals() {
    }
```
**Test 6:** This test checks the calculated hypothesis test (to be done)

```java
    @Test
    void calculateHypothesisTests() {
    }
```
**Test 7:** This test checks the predicted value (to be done)

```java
    @Test
    void predict() {
    }
```

**Test 7:** This test checks if the analysis report is correc (to be done)

```java
    @Test
    void generateAnalysisReport() {
    }
```


# 5. Construction (Implementation)


## Class RegisterUserController 

```java
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
    public boolean createPerson(String name, int taxNumber, String emailAddress, int telephoneNumber, Address address, PassportCard passport, Role role){
        Person person = new Person(name, taxNumber, emailAddress, telephoneNumber, address, role, passport);
        return PersonRepository.addPerson(person);
    }

    /**
     * Saves a new User in the AuthenticationRepository and returns the operation success.
     *
     * @param name
     * @param emailAddress
     * @param password
     * @param telephoneNumber
     * @return opperation success
     */
    public boolean createUser (String name, String emailAddress, String password, int telephoneNumber){
        return AuthenticationRepository.addUserWithRole(name,emailAddress,password, AuthenticationController.ROLE_USER);
    }

    public boolean checkUserExists (String email){
        return authenticationFacade.existsUser(email);
    }
}
```

# 6. Integration and Demo 

* None at the moment


# 7. Observations

The AuthenticationUI has a similar use as this US, so it's hard to differentiate between them.





