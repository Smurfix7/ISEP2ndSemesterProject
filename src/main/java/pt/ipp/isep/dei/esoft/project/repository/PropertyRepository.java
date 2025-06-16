package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Serialization;

import java.util.ArrayList;
import java.util.List;

public class PropertyRepository {

    private static final String FILE_PATH = "PropertyRepository.ser";
    Serialization serialization = new Serialization();
    List<Property> properties= new ArrayList<>();

    public void addProperty(Property property){
        if(validateProperty(property)){
            properties.add(property);
        }

    }

    public boolean validateProperty(Property property){
        if(properties.contains(property)){
            return false;

        }else {return true;}
    }

    public List<Property> getProperties(){
        return properties;
    }

    @SuppressWarnings("unchecked")
    public void saveRepository() {
        serialization.toWrite((List<Object>) (List<?>) properties, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadRepository() {
        this.properties = (List<Property>) (List<?>) serialization.toRead(FILE_PATH);
        Property.setCont(properties.size());
    }
}
