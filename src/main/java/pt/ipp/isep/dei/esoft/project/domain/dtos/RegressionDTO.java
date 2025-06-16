package pt.ipp.isep.dei.esoft.project.domain.dtos;

import pt.ipp.isep.dei.esoft.project.domain.MultiLinear;
import pt.ipp.isep.dei.esoft.project.domain.SimpleLinear;

public class RegressionDTO {

    private MultiLinear multi;

    private SimpleLinear simple;

    private String report;

    public RegressionDTO()
    {

    }
    public RegressionDTO(SimpleLinear simple, MultiLinear multi, String report){
        this.simple = simple;
        this.multi = multi;
        this.report = report;
    }



    public String getReport() {
        return report;
    }

    public SimpleLinear getSimple() {
        return simple;
    }

    public MultiLinear getMulti() {
        return multi;
    }
}
