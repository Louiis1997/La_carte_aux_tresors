package fr.carbonIt.infrastructure;

import fr.carbonIt.domain.FileWriter;
import fr.carbonIt.domain.exceptions.FileWriterException;

import java.io.File;

public class JavaIoFileWriter implements FileWriter {
    @Override
    public void write(String filename, String content) {
        try {
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();

            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
            throw new FileWriterException("Error while writing file (filename = " + filename + ")");
        }
    }
}
