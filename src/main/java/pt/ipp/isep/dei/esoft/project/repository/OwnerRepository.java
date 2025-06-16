package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a repository for owners.
 */

public class OwnerRepository {
    private static final String FILE_PATH = "OwnerRepository.ser";
    Serialization serialization = new Serialization();
    /**
     * List of owners
     */
    private static List<Owner> owners = new ArrayList<>();

    /**
     * Size of the repository
     */
    private static int size = 0;

    /**
     * Gets an owner from the repository
     * @param i
     * @return
     */
    public static Owner getOwner(int i) {return owners.get(i);}

    /**
     * Adds an owner to the repository
     *
     * @param owner to add
     */
    public static void addOwner(Owner owner) {
        owners.add(owner);
        size++;
    }

    /**
     * Gets an owner by email address
     *
     * @param email the email address of the owner
     * @return the owner with the given email address, or null if not found
     */
    public static Owner getOwnerByEmail(String email) {
        for (Owner owner : owners) {
            if (owner.getEmailAddress().equals(email)) {
                return owner;
            }
        }
        return null;
    }

    public static void displayOwners(){
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(i+1 + "#| "+ owners.get(i).toString());
        }
    }



    /**
     * Returns the size of the repository.
     *
     * @return size of the repository
     */
    public static int size() {
        return size;
    }

    /**
     * Returns a list of all owners in the repository.
     *
     * @return a list of owners
     */
    public static List<Owner> owners() {
        return new ArrayList<>(owners);
    }

    public static int getNumberOfOwners(){return owners.size();}

    @SuppressWarnings("unchecked")
    public void saveRepository() {
        serialization.toWrite((List<Object>) (List<?>) owners, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadRepository() {
        this.owners = (List<Owner>) (List<?>) serialization.toRead(FILE_PATH);
        Owner.setCont(owners().size());
    }


}


