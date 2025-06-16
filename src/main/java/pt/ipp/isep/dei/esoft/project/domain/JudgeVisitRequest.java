package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRequestsRepository;

import java.io.IOException;

public class JudgeVisitRequest {

    /**
     * Judges a property request based on user inputs
     */
    public static String judgeVisitRequest(String agentName, VisitRequest visitRequest, boolean acceptance, String justification) {
        Repositories repositories = Repositories.getInstance();
        VisitRequestsRepository visitRequestsRepository = repositories.getVisitRequestsRepository();
        String message;

        if (acceptance) {
            visitRequestsRepository.addVisitRequestAccepted(visitRequest);
            visitRequestsRepository.removeVisitRequest(visitRequest);
            message = "The visit request was accepted by agent " + agentName + "!";
            sendEmail("Your visit request was accepted! "+message);
        } else {
            visitRequestsRepository.removeVisitRequest(visitRequest);
            message = "The visit request was denied by agent " + agentName + "!";
            sendEmail("Your visit request was denied!" + message + "\n" + "Justification: " + justification);

        }
        return message;
    }

    /**
     * Send email with justification
     * @param justification
     * @return result
     */
    public static String sendEmail(String justification) {
        SendEmail sendEmailClass = new SendEmail();
        String result;
        try {
            sendEmailClass.sendEmail(justification);
            result = "Email Sent!";
        } catch (IOException e) {
            result = "Email Not Sent!";
        }
        return result;
    }
}
