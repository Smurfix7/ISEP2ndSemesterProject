package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SendEmailTest {

    /**
     * This test checks the email file and its contents to see if they are created correctly
     *
     * @throws IOException
     */
    @Test
    void sendEmail() throws IOException {
        SendEmail sendEmailClass = new SendEmail();
        String filePath = System.getProperty("user.home") + "/Desktop/testfile.txt";

        String testData = "Hello, World!";

        sendEmailClass.sendEmail(testData);

        String fileContent = Files.readString(Path.of(filePath));
        assertEquals(testData, fileContent);
    }
}