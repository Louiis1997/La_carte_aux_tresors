package fr.carbonIt.infrastructure;

import fr.carbonIt.domain.FileReader;
import fr.carbonIt.domain.FileWriter;
import fr.carbonIt.domain.models.Map;
import fr.carbonIt.infrastructure.input.Parser;
import fr.carbonIt.infrastructure.output.OutputGenerator;

public class MapFileHandler {
    FileReader fileReader;
    FileWriter fileWriter;
    Parser parser;
    OutputGenerator outputGenerator;
    public MapFileHandler(FileReader fileReader, FileWriter fileWriter, Parser parser, OutputGenerator outputGenerator) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.parser = parser;
        this.outputGenerator = outputGenerator;
    }

    public void handle(String[] args) {
        String inputFilePath = args[0];
        String input = fileReader.read(inputFilePath);
        Map map = parser.parseFileToDomain(input);
        map.moveAdventurers(map.getAdventurers());
        String output = outputGenerator.generateOutput(map);
        fileWriter.write(System.getProperty("user.dir") + "/src/main/resources/output.txt", output);
    }
}
