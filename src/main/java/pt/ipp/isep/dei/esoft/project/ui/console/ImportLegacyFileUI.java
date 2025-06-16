package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.ImportLegacyFileController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ImportLegacyFileUI implements Runnable {
    private final Scanner read;
    private final ImportLegacyFileController controller = new ImportLegacyFileController();

    /**
     * Constructs an ImportLegacyFileUI object.
     * Initializes the Scanner for reading user input.
     */
    public ImportLegacyFileUI() {
        this.read = new Scanner(System.in);
    }

    public void run() {
        System.out.println();
        System.out.println("|------------------------|");
        System.out.println(" >> Import Legacy File <<");
        System.out.println("|------------------------|");
        System.out.println();

        boolean fileImported = false;

        while (!fileImported) {
            String filePath = requestsFilePath();

            if (Utils.validateFile(filePath)) {
                File legacyFile = new File(filePath);
                try {
                    controller.importLegacyFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println();
                    System.out.println("File Not Found!");
                    System.out.println();
                }

                fileImported = true;
            } else {
                System.out.println();
                System.out.print("File Not Imported, try again...");
            }
        }
        System.out.println();
        System.out.println("File Imported with Success!");
    }

    /**
     * Requests the user to enter the file path for the legacy file.
     *
     * @return the user input for the file path
     */
    public String requestsFilePath() {
        System.out.println();
        System.out.print("Enter the File path: ");
        return read.next();
    }
}