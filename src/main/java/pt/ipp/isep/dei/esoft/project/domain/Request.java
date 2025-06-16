package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Request implements Serializable {

    private static int cont=0;
    private Property property;
    private Person owner;
    private String requestDate;
    private Employee agent;
    private Transaction transaction;
    private int requestID=0;
    private final Property PROPERTY_BY_DEFAULT = null;
    private final String REQUEST_DATE_BY_DEFAULT = "[NO DATA]";

    private final Person OWNER_BY_DEFAULT = null;
    private final Employee AGENT_BY_DEFAULT = null;
    private final Transaction TYPE_OF_TRANSACTION_BY_DEFAULT = null;

    public Request(Employee agent,Person owner, Property property, Transaction transaction){
        this.owner = owner;
        this.agent = agent;
        this.property = property;
        this.requestDate = String.valueOf(LocalDate.now());
        this.transaction = transaction;
        cont++;
        this.requestID = cont;
    }

    public Request(Employee agent, Person owner, Property property, Transaction transaction, String requestDate){
        this.owner = owner;
        this.agent = agent;
        this.property = property;
        this.requestDate = requestDate;
        this.transaction = transaction;
        cont++;
        this.requestID = cont;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Employee getAgent() {
        return agent;
    }

    public void setAgent(Employee agent) {
        this.agent = agent;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Transaction getTypeOfTransaction() {
        return transaction;
    }

    public void setTypeOfTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getRequestID() {
        return requestID;
    }

    @Override
    public String toString() {
        return "|Request #"+requestID+" | Agent: "+agent.getName()+"| Owner: "+owner.getName()+" | Business:"+ this.transaction.toString() +"  | Property: "+property.toString();
    }

    public static void setCont(int n) {
        cont = n;
    }
}
