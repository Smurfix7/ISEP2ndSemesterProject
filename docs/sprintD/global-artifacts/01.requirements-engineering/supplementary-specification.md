# Supplementary Specification (FURPS+)

## Functionality

_(Specifies functionalities that: are common across several US/UC; are not related to US/UC, namely: Audit, Reporting and Security.)_

###  - Email:
* Email is required to register a user.
* Email is required for a user to log in.
* It's required to send an email in the US03: "The password is sent to the employee by e-mail" (Question made in US003).
* It's required to send an email in the US08: "The system should also send the message to the owner by e-mail."
* It's required to send an email in the US11: "As an agent, I want to list real estate purchase orders to accept or decline a
  purchase order for a property. After accepting or declining, an email notification
  should be sent to the customer."

### - Localization:
* All properties must have their location specified.
* A client should be able to search a property by location.

### - Reporting:
* "After carrying out the visit, the agent records the visit and an indication of whether or not he thinks the deal will take place."

### - Security:
* All employees must be authenticated to be able to manage the property list.
* The administrator must be authenticated to be able to register employees.

### - System Management:
* All employees must be able to manage the property list.

### - Workflow:
* The store manager should be able the see status of the employees work to analyse and evaluate their performance.

## Usability

_(Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards.)_

### - Aesthetics & Design:
* Must be developed in Java language;
* Must be developed using IntelliJ IDE or NetBeans;
* Must "adopt best practices for identifying requirements, and for OO software analysis and design";
* Must "adopt recognizes coding conventions and standards";

### - Documentation:
* The documentation should be done in JavaDoc.

## Reliability
_(Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures.)_

### - Recoverability:
* "The application should use object serialization to ensure data persistence between two runs of the
  application".

## Performance:
_(Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability.)_

* None specified.


## Supportability
_(The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more.)_
### - Testability:
* "The development team must implement unit tests for all methods, except for methods that
implement Input/Output operations".
* "The unit tests should be implemented using the JUnit 5
  framework".
* "The JaCoCo plugin should be used to generate the coverage report".

## +

### Design Constraints
_(Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc.)_

* "The application graphical interface is to be developed in JavaFX 11."


### Implementation Constraints
_(Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system.)_

* Must be developed in Java language;
* Must be developed using IntelliJ IDE or NetBeans;
* Must "adopt best practices for identifying requirements, and for OO software analysis and design";
* Must "adopt recognizes coding conventions and standards";
* Must "use Javadoc to generate useful documentation for Java code";
* Must "implement unit tests for all methods, except for methods that implement Input/Output operations";
* "The unit tests should be implemented using the JUnit 5 framework";
* "The JaCoCo plugin should be used to generate the coverage report";
* "All the images/figures produced during the software development process should be record in the SVG format";
* "The application should use object serialization to ensure data persistence between two runs of the application".

### Interface Constraints
_(Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems.)_

* "The application graphical is to be developed in JavaFX 11".

### Physical Constraints
_(Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight.)_

* None Specified