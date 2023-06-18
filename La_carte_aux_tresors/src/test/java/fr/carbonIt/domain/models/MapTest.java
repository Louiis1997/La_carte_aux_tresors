package fr.carbonIt.domain.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapTest {
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
    void test_isPositionAvailable_should_be_true() {
        Assertions.assertTrue(map.isPositionAvailable(new Position(0, 1)));
    }

    @Test
    void test_isPositionAvailable_should_be_false_because_out_of_map() {
        Assertions.assertFalse(map.isPositionAvailable(new Position(0, 5)));
    }

    @Test
    void test_isPositionAvailable_should_be_false_because_mountain() {
        Assertions.assertFalse(map.isPositionAvailable(new Position(1, 0)));
    }

    @Test
    void test_moveAdventurers_should_equal() {
        map.moveAdventurers(map.getAdventurers());
        Adventurer Lara = map.getAdventurers()[0];
        System.out.print(map.toString());
        Assertions.assertEquals(0, Lara.getPosition().getHorizontalCoordinates());
        Assertions.assertEquals(3, Lara.getPosition().getVerticalCoordinates());
        Assertions.assertEquals(Orientation.S, Lara.getOrientation());
        Assertions.assertEquals(3, Lara.getTresureQuantity());
    }

    @Test
    void test_moveAdventurers_should_not_equal() {
        map.moveAdventurers(map.getAdventurers());
        Adventurer Lara = map.getAdventurers()[0];
        Assertions.assertNotEquals(1, Lara.getPosition().getHorizontalCoordinates());
        Assertions.assertNotEquals(1, Lara.getPosition().getVerticalCoordinates());
        Assertions.assertNotEquals(Orientation.W, Lara.getOrientation());
        Assertions.assertNotEquals(2, Lara.getTresureQuantity());
    }
}