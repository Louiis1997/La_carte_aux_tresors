package fr.carbonIt.infrastructure.output;

import fr.carbonIt.domain.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MapTxtOutputGeneratorTest {
    Map map = new Map(
            new MapDimension(3, 4),
            new Mountain[]{
                    new Mountain(new Position(1, 0)),
                    new Mountain(new Position(2, 1))
            },
            new Treasure[]{
                    new Treasure(new Position(0, 3), 2),
                    new Treasure(new Position(1, 3), 3)
            },
            new Adventurer[]{
                    new Adventurer(
                            "Lara",
                            new Position(1, 1),
                            Orientation.S,
                            new Instruction[]{
                                    Instruction.A,
                                    Instruction.A,
                                    Instruction.D,
                                    Instruction.A,
                                    Instruction.D,
                                    Instruction.A,
                                    Instruction.G,
                                    Instruction.G,
                                    Instruction.A
                            }
                    )
            }
    );

    @Test
    void test_generateOutput_shoud_equal() {
        String outputResult = """
                C - 3 - 4
                M - 1 - 0
                M - 2 - 1
                T - 1 - 3 - 2
                A - Lara - 0 - 3 - S - 3""";
        MapTxtOutputGenerator mapTxtOutputGenerator = new MapTxtOutputGenerator();
        map.moveAdventurers(map.getAdventurers());
        String output = mapTxtOutputGenerator.generateOutput(map);
        Assertions.assertEquals(outputResult, output);
    }

    @Test
    void test_generateOutput_shoud_not_equal() {
        String outputResult = """
                C - 3 - 4
                M - 1 - 0
                M - 2 - 1
                T - 1 - 3 - 2
                A - Lara - 0 - 3 - S - 3""";
        MapTxtOutputGenerator mapTxtOutputGenerator = new MapTxtOutputGenerator();
        String output = mapTxtOutputGenerator.generateOutput(map);
        Assertions.assertNotEquals(outputResult, output);
    }
}