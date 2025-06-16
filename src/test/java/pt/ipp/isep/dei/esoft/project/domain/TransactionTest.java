package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void getTransactionType() {
        Transaction tot = new Transaction();
        tot.setTransactionType("Lease");

        assertEquals("Lease", tot.getTransactionType());
    }

    @Test
    void setTransactionType() {
        Transaction tot = new Transaction();
        tot.setTransactionType("Lease");

        assertEquals("Lease", tot.getTransactionType());
    }

    @Test
    void getMonetaryValue() {
        Transaction tot = new Transaction();
        tot.setMonetaryValue(1000);

        assertEquals(1000, tot.getTransactionType());
    }

    @Test
    void setMonetaryValue() {
        Transaction tot = new Transaction();
        tot.setMonetaryValue(1000);

        assertEquals(1000, tot.getTransactionType());
    }

    @Test
    void testToString() {
        Transaction tot = new Transaction("Lease",1000 );

        assertEquals(" | Transaction Type: Lease | Value: 1000", tot.toString());
    }
}