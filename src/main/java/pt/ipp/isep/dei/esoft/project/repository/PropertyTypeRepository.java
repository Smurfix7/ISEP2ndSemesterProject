package pt.ipp.isep.dei.esoft.project.repository;

/**
 * This class represents a repository for property types.
 */
public class PropertyTypeRepository {

    /**
     * Array of property types.
     */
    String[] propertyTypes = {"LAND", "APARTMENT", "HOUSE"};

    /**
     * Gets a property type from the repository.
     *
     * @param n the index of the property type to get
     * @return the property type at the specified index
     */
    public String getPropertyType(int n) {
        return propertyTypes[n-1];
    }

    /**
     * Displays all the property types in the repository.
     *
     * @return a string containing all the property types and their corresponding indices
     */
    public String displayPropertyTypes() {
        return "1: " + propertyTypes[0] +
                "\n2: " + propertyTypes[1] +
                "\n3: " + propertyTypes[2];
    }

    public String[] getPropertyTypeList(){return propertyTypes;}
}

