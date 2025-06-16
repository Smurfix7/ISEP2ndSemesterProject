package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Serialization;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static final String FILE_PATH = "PersonRepository.ser";
    Serialization serialization = new Serialization();
    /**
     * List of people
     */
    static List<Person> people = new ArrayList<>();
    /**
     * Size of the repository
     */
    static int size = 0;

    /**
     * Gets a person from the repository
     *
     * @param person to get
     * @return the person if it exists
     */
    public Person getPerson(Person person) {
        if (people.contains(person)) {
            return person;
        } else {
            return null;
        }
    }

    /**
     * Adds a person to the repository
     *
     * @param person
     * @return
     */

    public static boolean addPerson(Person person) {
        people.add(person);
        size++;
        return true;
    }

    /**
     * Gets a person from the arrayList by their number in the list.
     *
     * @param n position in the list
     * @return the announcement
     */
    public static Person getPeople(int n) {
        return people.get(n);
    }

    /**
     * Returns the size of the repository.
     *
     * @return size of the repository
     */
    public static int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public void saveRepository() {
        serialization.toWrite((List<Object>) (List<?>) people, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadRepository() {
        this.people = (List<Person>) (List<?>) serialization.toRead(FILE_PATH);
    }
}
