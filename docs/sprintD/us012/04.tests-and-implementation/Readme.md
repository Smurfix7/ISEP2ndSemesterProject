# US 007 - To Register in the System 

# 4. Tests 

**Test 1:** 

    @Test
    void importLegacyFile() {
        ImportLegacyFileController controller = new ImportLegacyFileController();
        LegacyFile test = new LegacyFile("/system/files/legacyfile.csv");

        assertEquals(test, controller.ImportLegacyFile("/system/files/legacyfile.csv"));
    }

**Test 2:** 

    @Test
    void getFilePath() {
        LegacyFile legacyFile = new LegacyFile();
        legacyFile.setFilePath("/system/files/legacyFile.csv");

        assertEquals("/system/files/legacyFile.csv", legacyFile.getFilePath());
    }

    @Test
    void setFilePath() {
        LegacyFile legacyFile = new LegacyFile();
        legacyFile.setFilePath("/system/files/legacyFile.csv");

        assertEquals("/system/files/legacyFile.csv", legacyFile.getFilePath());
    }

    @Test
    void testToString() {
       LegacyFile legacyFile = new LegacyFile("/system/files/legacyFile.csv");

        assertEquals("Path To Legacy File: /system/files/legacyFile.csv", legacyFile.toString());
    }

**Test 2:**

    @Test
    void getLegacyFile() {
    }

    @Test
    void addLegacyFile() {
    }

    @Test
    void size() {
    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class LegacyFile

```java
public class LegacyFile {
    private String filePath;
    private final String PATH_TO_LEGACY_FILE_BY_DEFAULT = "[NO DATA]";

    /**
     * This method creates the LegacyFile object with default attributes
     */
    public LegacyFile() {
        this.filePath = PATH_TO_LEGACY_FILE_BY_DEFAULT;
    }

    /**
     * @param filePath
     */
    public LegacyFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method returns the filePath of the LegacyFile
     *
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method changes the filePath of the LegacyFile
     *
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the Legacy File
     *
     * @return
     */
    @Override
    public String toString() {
        return "Path To Legacy File: " + filePath;
    }
}
```

## Class LegacyFileRepository

```java
public class LegacyFileRepository {

    /**
     * List of legacyFiles
     */
    public static List<String[][]> legacyFiles = new ArrayList<>();

    /**
     * Size of the repository
     */
    static int size = 0;

    /**
     * Gets an legacyFile from the repository
     *
     * @param legacyFile to get
     * @return the agent if it exists
     */
    public String[][] getLegacyFile(String[][] legacyFile) {
        if (legacyFiles.contains(legacyFile)) {
            return legacyFile;
        } else {
            return null;
        }
    }

    /**
     * Adds an legacyFile to the repository
     *
     * @param legacyFile
     */
    public static void addLegacyFile(String[][] legacyFile) {
        legacyFiles.add(legacyFile);
        size++;
    }

    /**
     * Returns the size of the repository.
     *
     * @return size of the repository
     */
    public static int size() {
        return size;
    }

}
```

## Class ImportLegacyFileController

```java
public class ImportLegacyFileController {
    public Object ImportLegacyFile(String filePath){
        return new LegacyFile(filePath);
    }
}
```

# 6. Integration and Demo 

* None at the moment


# 7. Observations

The AuthenticationUI has a similar use as this US, so it's hard to differentiate between them.





