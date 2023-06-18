package fr.carbonIt.infrastructure;

import fr.carbonIt.domain.FileReader;
import fr.carbonIt.domain.exceptions.FileReaderException;

import java.nio.file.Files;
import java.nio.file.Path;

public class JavaIoFileReader implements FileReader {
    @Override
    public String read(String filename) {
        try {
            Path filePath = Path.of(filename);
            return Files.readString(filePath);
        } catch (Exception e) {
            throw new FileReaderException("Error while reading file " + filename);
        }
    }
}
