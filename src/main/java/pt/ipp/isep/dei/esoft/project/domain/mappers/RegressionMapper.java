package pt.ipp.isep.dei.esoft.project.domain.mappers;

import pt.ipp.isep.dei.esoft.project.domain.MultiLinear;
import pt.ipp.isep.dei.esoft.project.domain.SimpleLinear;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RegressionDTO;

public class RegressionMapper {

    public static RegressionDTO toDto(SimpleLinear simpleLinear, MultiLinear multiLinear, String report){
        return new RegressionDTO(simpleLinear, multiLinear, report);
    }
}
