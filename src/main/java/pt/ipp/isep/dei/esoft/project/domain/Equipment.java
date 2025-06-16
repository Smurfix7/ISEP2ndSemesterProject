package pt.ipp.isep.dei.esoft.project.domain;
import java.io.Serializable;
import java.util.ArrayList;

public class Equipment implements Serializable {

    // ATTRIBUTES

    private ArrayList<String> equipmentList;

    private final ArrayList<String> EQUIPMENT_BY_DEFAULT = new ArrayList<>();

    // CONSTRUCTORS

    /**
     * This method creates the Equipment object with the default attributes
     */
    public Equipment(){
        this.equipmentList = EQUIPMENT_BY_DEFAULT;
    }


    public Equipment(ArrayList<String> equipment){
        this.equipmentList = equipment;
    }

    // SETS AND GETS

    public void setEquipmentList(ArrayList<String> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public ArrayList<String> getEquipmentList() {
        return equipmentList;
    }

    /**
     * This method returns the status of the air conditioning equipment
     *
     * @return
     */

    // TOSTRING
    @Override
    public String toString() {
        String message = " |Equipment: ";
        for (int i = 0; i < this.equipmentList.size(); i++) {
            message = message + equipmentList.get(i) + ",1 ";
        }
        return message;
    }
}
