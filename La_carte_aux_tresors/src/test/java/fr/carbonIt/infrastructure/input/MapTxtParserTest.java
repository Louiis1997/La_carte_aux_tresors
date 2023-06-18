package fr.carbonIt.infrastructure.input;

import fr.carbonIt.domain.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapTxtParserTest {
    String input = """
                C - 3 - 4
                M - 1 - 0
                M - 2 - 1
                T - 0 - 3 - 2
                T - 1 - 3 - 3
                A - Lara - 1 - 1 - S - AADADAGGA""";
    @Test
    void test_parse_string_to_model_should_equal() {
        MapTxtParser mapTxtParser = new MapTxtParser();
        Map myMap = mapTxtParser.parseFileToDomain(input);
        Map mapTest = new Map(
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
        Assertions.assertEquals(mapTest, myMap);
    }

    @Test
    void test_parse_string_to_model_should_not_equal() {
        MapTxtParser mapTxtParser = new MapTxtParser();
        Map myMap = mapTxtParser.parseFileToDomain(input);
        Map mapTest = new Map(
                new MapDimension(3, 3),
                new Mountain[]{
                        new Mountain(new Position(1, 1)),
                        new Mountain(new Position(2, 1))
                },
                new Treasure[]{
                        new Treasure(new Position(1, 3), 1),
                        new Treasure(new Position(1, 3), 3)
                },
                new Adventurer[]{
                        new Adventurer(
                                "Laura",
                                new Position(1, 0),
                                Orientation.N,
                                new Instruction[]{
                                        Instruction.A,
                                        Instruction.A,
                                        Instruction.A,
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
        Assertions.assertNotEquals(mapTest.getMapDimension(), myMap.getMapDimension());
        Assertions.assertNotEquals(mapTest.getMountains(), myMap.getMountains());
        Assertions.assertNotEquals(mapTest.getTreasures(), myMap.getTreasures());
        Assertions.assertNotEquals(mapTest.getAdventurers(), myMap.getAdventurers());
    }
}