package pt.ipp.isep.dei.esoft.project.domain;

import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.io.Serializable;

public class Owner extends Person implements Serializable {
    private static int cont=0;
    private int ownerID;
    public Owner() {
        super();
    }

    public Owner(String name, String taxNumber,String telephoneNumber, String emailAddress,  Address address, Role role, PassportCard passportCard) {
        super(name, taxNumber, emailAddress, telephoneNumber, address, role, passportCard);
        cont++;
        this.ownerID = cont;
    }

    public Owner(String name, String taxNumber, String emailAddress, String telephoneNumber, Role role, PassportCard passportCard) {
        super(name, taxNumber, emailAddress, telephoneNumber, new Address(), role, passportCard);
        cont++;
        this.ownerID = cont;
    }

    public static void setCont(int n) {
        cont = n;
    }

    public String toString() {
        return "Owner: " + super.toString();
    }
}
