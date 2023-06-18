package fr.carbonIt;

import fr.carbonIt.domain.FileReader;
import fr.carbonIt.domain.FileWriter;
import fr.carbonIt.infrastructure.JavaIoFileReader;
import fr.carbonIt.infrastructure.JavaIoFileWriter;
import fr.carbonIt.infrastructure.MapFileHandler;
import fr.carbonIt.infrastructure.input.MapTxtParser;
import fr.carbonIt.infrastructure.input.Parser;
import fr.carbonIt.infrastructure.output.MapTxtOutputGenerator;
import fr.carbonIt.infrastructure.output.OutputGenerator;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new JavaIoFileReader();
        FileWriter fileWriter = new JavaIoFileWriter();
        Parser parser = new MapTxtParser();
        OutputGenerator outputGenerator = new MapTxtOutputGenerator();

        MapFileHandler mapFileHandler = new MapFileHandler(fileReader, fileWriter, parser, outputGenerator);
        mapFileHandler.handle(args);
    }
}