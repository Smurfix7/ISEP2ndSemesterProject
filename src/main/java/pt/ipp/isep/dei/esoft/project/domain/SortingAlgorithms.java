package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.dtos.VisitRequestsListDTO;

import java.util.List;

public class SortingAlgorithms {

    /**
     * Sort the Visit Requests List DTOs with the bubble sort method
     * @param visitRequestsListDTOS
     * @return
     */
    public static List<VisitRequestsListDTO> bubbleSort(List<VisitRequestsListDTO> visitRequestsListDTOS) {

        int size = visitRequestsListDTOS.size();

        for (int i = 0; i < size - 1; ++i) {
            for (int j = 0; j < size - i - 1; ++j) {
                VisitRequestsListDTO visitRequest1 = visitRequestsListDTOS.get(j);
                VisitRequestsListDTO visitRequest2 = visitRequestsListDTOS.get(j + 1);

                if (visitRequest1.getDate().compareTo(visitRequest2.getDate()) > 0) {
                    visitRequestsListDTOS.set(j, visitRequest2);
                    visitRequestsListDTOS.set(j + 1, visitRequest1);
                }
            }
        }
        return visitRequestsListDTOS;
    }

    /**
     * Sort the Visit Requests List DTOs with the insertion sort method
     * @param visitRequestsListDTOS
     * @return
     */
    public static List<VisitRequestsListDTO> insertionSort(List<VisitRequestsListDTO> visitRequestsListDTOS) {

        int size = visitRequestsListDTOS.size();

        for (int i = 1; i < size; ++i) {
            VisitRequestsListDTO key = visitRequestsListDTOS.get(i);
            int j = i - 1;

            while (j >= 0 && visitRequestsListDTOS.get(j).getDate().compareTo(key.getDate()) > 0) {
                visitRequestsListDTOS.set(j + 1, visitRequestsListDTOS.get(j));
                j = j - 1;
            }

            visitRequestsListDTOS.set(j + 1, key);
        }
        return visitRequestsListDTOS;
    }
}
