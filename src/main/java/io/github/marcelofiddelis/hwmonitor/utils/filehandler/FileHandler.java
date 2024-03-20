package io.github.marcelofiddelis.hwmonitor.utils.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    public static BufferedReader getFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            return reader;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

       
    }
}
