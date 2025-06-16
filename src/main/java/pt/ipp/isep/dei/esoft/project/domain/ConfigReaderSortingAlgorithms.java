package pt.ipp.isep.dei.esoft.project.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderSortingAlgorithms {
    public static String getSortingAlgorithm(String configFile, String algorithm) {

        try (InputStream in = new FileInputStream(configFile)) {
            Properties props = new Properties();
            props.load(in);

            String algorithm1 = props.getProperty("algorithm1");
            String algorithm2 = props.getProperty("algorithm2");

            if (algorithm.equalsIgnoreCase("bubble")){
                algorithm = algorithm1;
            } else {
                algorithm = algorithm2;
            }

        } catch (IOException e) {
            System.out.println("Reading Configuration File Failed!: " + e.getMessage());
        }
        return algorithm;
    }
}
