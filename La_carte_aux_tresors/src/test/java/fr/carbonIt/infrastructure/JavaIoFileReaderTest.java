package fr.carbonIt.infrastructure;

import fr.carbonIt.domain.exceptions.FileReaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaIoFileReaderTest {
    @Test
    void test_read_a_file_should_return_same_content() {
        JavaIoFileReader javaIoFileReader = new JavaIoFileReader();

        String content = javaIoFileReader.read(System.getProperty("user.dir") + "/src/test/resources/InputMap.txt");

        Assertions.assertEquals("""     
            C - 3 - 4
            M - 1 - 0
            M - 2 - 1
            T - 0 - 3 - 2
            T - 1 - 3 - 3
            A - Lara - 1 - 1 - S - AADADAGGA""", content);
    }

    @Test
    void test_file_not_found_should_throw_exception() {
        JavaIoFileReader javaIoFileReader = new JavaIoFileReader();
        Assertions.assertThrows(FileReaderException.class, () -> javaIoFileReader.read(System.getProperty("user.dir") + "/src/test/resources/InputMap2.txt"));
    }

    @Test
    void test_read_a_file_should_not_equal() {
        JavaIoFileReader javaIoFileReader = new JavaIoFileReader();

        String content = javaIoFileReader.read(System.getProperty("user.dir") + "/src/test/resources/InputMap.txt");

        Assertions.assertNotEquals("""     
            C - 3 - 3
            M - 1 - 0
            M - 2 - 1
            T - 0 - 3 - 2
            T - 1 - 3 - 3
            A - Lara - 1 - 1 - S - AADADAGGA""", content);
    }
}