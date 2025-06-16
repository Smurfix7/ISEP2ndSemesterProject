package pt.ipp.isep.dei.esoft.project.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderEmail {
    public static String getSortingAlgorithm(String configFile, String algorithm) {

        try (InputStream in = new FileInputStream(configFile)) {
            Properties props = new Properties();
            props.load(in);

            String domain1 = props.getProperty("domain1");
            String domain2 = props.getProperty("domain2");
            String domain3 = props.getProperty("domain3");
            String domain4 = props.getProperty("domain4");
            String domain5 = props.getProperty("domain5");
            String domain6 = props.getProperty("domain6");
            String domain7 = props.getProperty("domain7");

        } catch (IOException e) {
            System.out.println("Reading Configuration File Failed!: " + e.getMessage());
        }
        return algorithm;
    }
}
