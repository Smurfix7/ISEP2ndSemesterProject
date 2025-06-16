package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentTest {

    @Test
    void getAgency() {
        Address address = new Address("Lt Jenkins", "Huston", "Texas",  "123-12-1234");
        Agency agency = new Agency("Era", "Era", "Era@gmail.com","919919919",address);
        Employee agent = new Employee();
        agent.setAgency(agency);

        assertEquals("Era", agent.getAgency().getAgencyName());
    }

    @Test
    void setAgency() {
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "123-12-1234");
        Agency agency = new Agency("Era", "Era", "Era@gmail.com","919919919",address);
        Employee agent = new Employee();
        agent.setAgency(agency);

        assertEquals("Era", agent.getAgency().getAgencyName());
    }

    @Test
    void testToString() {
        PassportCard passportCard = new PassportCard("123456");
        Address address = new Address("Lt Jenkins", "Huston", "Texas", "123-12-1234");
        Address agencyAddress = new Address("Lt Jenkins", "Huston", "Texas", "123-12-1234");
        Role role = new Role("123456","Manager");
        Agency agency = new Agency("Era", "Era", "Era@gmail.com","919919919", agencyAddress);
        Person person = new Person("Pedro", "123-456-1178", "dummy@domain.com", "999-555-2222",address,role,passportCard);
        Employee agent = new Employee(person.getName(),person.getTaxNumber(),person.getEmailAddress(),person.getTelephoneNumber(),person.getAddress(),person.getRole(),person.getPassportCard(),agency);

        String expectedString = "Agent: Pedro | Tax Number: 123-456-1178 | Email Address: dummy@domain.com | Telephone Number: 999-555-2222 | Address: Lt Jenkins, Huston, Texas, 123-12-1234 | Role: Manager | Role ID: 123456 | Agency ID: Era";

        assertEquals(expectedString, agent.toString());
    }
}
