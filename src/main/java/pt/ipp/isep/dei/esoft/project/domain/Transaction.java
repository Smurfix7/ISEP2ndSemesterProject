package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class Transaction implements Serializable {

    // ATTRIBUTES

    private String transactionType;
    private double monetaryValue;

    private final String TRANSACTION_TYPE_BY_DEFAULT =  "[NO DATA]";
    private final double MONETARY_VALUE_BY_DEFAULT = 0;

    // CONSTRUCTORS

    /**
     * This method creates the TypeOfTransaction object with default attributes
     */
    public Transaction(){
        this.transactionType = TRANSACTION_TYPE_BY_DEFAULT;
        this.monetaryValue = MONETARY_VALUE_BY_DEFAULT;
    }

    /**
     *
     *  This method creates the TypeOfTransaction object
     *
     * @param transactionType
     * @param monetaryValue
     */
    public Transaction(String transactionType, double monetaryValue){
        this.transactionType = transactionType;
        this.monetaryValue = monetaryValue;
    }

    // SETS AND GETS

    /**
     *  This method returns the transactionType of the TypeOfTransaction
     *
     * @return
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     *  This method changes the transactionType of the TypeOfTransaction
     * @param transactionType
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     *  This method returns the monetaryValue of the TypeOfTransaction
     *
     * @return
     */
    public double getMonetaryValue() {
        return monetaryValue;
    }

    /**
     *  This method changes the monetaryValue of the TypeOfTransaction
     * @param monetaryValue
     */
    public void setMonetaryValue(double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the TransactionType
     * @return
     */
    @Override
    public String toString() {
        return " | Transaction Type: "+transactionType+" | Value: "+monetaryValue;
    }
}
