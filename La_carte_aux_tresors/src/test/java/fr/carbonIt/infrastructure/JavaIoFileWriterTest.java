package fr.carbonIt.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class JavaIoFileWriterTest {
    @Test
    void test_write_in_a_file() {
        String outputResult = """
            C - 3 - 4
            M - 1 - 0
            M - 2 - 1
            T - 1 - 3 - 2
            A - Lara - 0 - 3 - S - 3""";
        JavaIoFileWriter javaIoFileWriter = new JavaIoFileWriter();
        javaIoFileWriter.write(System.getProperty("user.dir") + "/src/test/resources/OutputResult.txt", outputResult);

        JavaIoFileReader javaIoFileReader = new JavaIoFileReader();
        String content = javaIoFileReader.read(System.getProperty("user.dir") + "/src/test/resources/OutputResult.txt");
        Assertions.assertEquals(outputResult, content);
        new File(System.getProperty("user.dir") + "/src/test/resources/OutputResult.txt").delete();
    }
}