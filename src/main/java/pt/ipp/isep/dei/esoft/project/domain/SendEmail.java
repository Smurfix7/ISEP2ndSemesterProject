package pt.ipp.isep.dei.esoft.project.domain;

import java.io.*;

public class SendEmail {

    static int emailCounter = 0;

    private static String FOLDER = "sent_emails/";
    public void sendEmail(String message) throws IOException {
        getAbsolutePath();
        this.emailCounter++;
        String filePath = emailCounter+".txt";

        try {
            FileWriter fileWriter = new FileWriter(FOLDER + filePath);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(message);

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getAbsolutePath() {
        // Get the absolute path of the JAR file
        String jarPath = Serialization.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            // Decode the URL-encoded path
            String decodedPath = java.net.URLDecoder.decode(jarPath, "UTF-8");
            // Get the parent directory of the JAR file
            File jarFile = new File(decodedPath);
            String parentPath = jarFile.getParent();
            // Construct and return the absolute file path
            FOLDER = parentPath + File.separator + FOLDER;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}


