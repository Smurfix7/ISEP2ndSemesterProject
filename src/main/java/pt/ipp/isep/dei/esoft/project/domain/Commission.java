package pt.ipp.isep.dei.esoft.project.domain;


import java.io.Serializable;

public class Commission implements Serializable {
    String commissionType;
    Double commissionValue;

    public Commission(String commissionType, Double commissionValue){
        this.commissionValue = commissionValue;
        this.commissionType = commissionType;
    }


    public String toString(){
        if(commissionValue == null || commissionType ==null || this == null){
            return "No Comission added";
        } else{
            return "Commission Type: " + commissionType + ", valued at: " + commissionValue;
        }
    }

    public Double getCommissionValue(){return this.commissionValue;}
    public String getCommissionType(){return this.commissionType;}
}
