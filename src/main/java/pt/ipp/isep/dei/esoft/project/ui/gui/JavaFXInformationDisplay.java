package pt.ipp.isep.dei.esoft.project.ui.gui;

import java.util.ArrayList;
import java.util.List;

public class JavaFXInformationDisplay {

    private List<String> information = new ArrayList<>();


    @Override
    public String toString() {
        List<String> copy = new ArrayList<>(information);

        StringBuilder s = new StringBuilder();
        for (String sentence : copy) {
            s.append(sentence);
            s.append("\n");
        }

        return s.toString().trim();
    }

    public void reset() {
        information.clear();
    }
    public void addSentence(String sentence){
        information.add(sentence);
    }
}
