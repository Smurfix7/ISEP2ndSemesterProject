package pt.ipp.isep.dei.esoft.project.domain.mappers;

import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RequestDto;

import java.util.ArrayList;

public class RequestMapper {
    public static ArrayList<RequestDto> toDto(ArrayList<Request> list){
        ArrayList<RequestDto> requestDtoList= new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Request obj = list.get(i);
            RequestDto dto = new RequestDto(obj.getRequestID(),obj.getRequestDate(),obj.getTypeOfTransaction(),obj.getAgent(),obj.getOwner(),obj.getProperty());

            requestDtoList.add(dto);
        }

        return requestDtoList;
    }
}
