package com.mainacad.servive;

import java.io.*;

public class FileService {

    public static final String MAIN_DIR = System.getProperty("user.dir");
    public static final String SEP = System.getProperty("file.separator");
    public static final String FILES_DIR = MAIN_DIR + SEP + "files";

    // work with text
    public static void writeTextToFile(String text, String fileName){
        checkTargetDir();

        try (FileWriter fileWriter = new FileWriter(FILES_DIR + SEP + fileName)) {
            fileWriter.write(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkTargetDir() {
        File file = new File(FILES_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static String readTextFromFile(String fileName){
        String out = "";

        try (
             FileReader fileReader = new FileReader(FILES_DIR + SEP + fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
            ) {
            String line;
            while ( (line = bufferedReader.readLine()) != null ) {
                out += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out;
    }

}
