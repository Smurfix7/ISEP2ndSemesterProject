package pt.ipp.isep.dei.esoft.project.domain;

import java.io.*;

public class Notification implements Message{

    private static String FOLDER = "notification/notification.txt";
    @Override
    public void sendMessage(String text) {

        getAbsolutePath();
        try {
            FileWriter fileWriter = new FileWriter(FOLDER);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(text);

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
