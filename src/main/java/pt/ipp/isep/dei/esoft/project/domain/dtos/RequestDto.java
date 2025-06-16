package pt.ipp.isep.dei.esoft.project.domain.dtos;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Transaction;

public class RequestDto {
    private int ID;

    private String requestDate;

    private Transaction transaction;

    private Employee agent;

    private Person owner;

    private Property property;

    public RequestDto(int ID, String requestDate,Transaction transaction, Employee agent, Person owner, Property property){
        this.ID = ID;
        this.transaction = transaction;
        this.requestDate = requestDate;
        this.agent = agent;
        this.owner = owner;
        this.property = property;
    }

    public String toString() {
        return "|Request #"+ID+" | Agent: "+agent.getName()+"| Owner: "+owner.getName()+ transaction.toString() + " | Property: "+property;
    }

    public int getID() { return this.ID;}
}
