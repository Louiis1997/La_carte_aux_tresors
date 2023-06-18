package fr.carbonIt.domain.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdventurerTest {

    @Test
    void test_moveForward_should_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.N, new Instruction[]{Instruction.A});
        adventurer.moveForward();
        Assertions.assertEquals(new Position(1, 0), adventurer.getPosition());
    }

    @Test
    void test_turnLeft_should_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.N, new Instruction[]{Instruction.A});
        adventurer.turnLeft();
        Assertions.assertEquals(Orientation.W, adventurer.getOrientation());
    }

    @Test
    void test_turnRight_should_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.N, new Instruction[]{Instruction.A});
        adventurer.turnRight();
        Assertions.assertEquals(Orientation.E, adventurer.getOrientation());
    }

    @Test
    void test_getNextPosition_should_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.N, new Instruction[]{Instruction.A});
        Assertions.assertEquals(new Position(1, 0), adventurer.getNextPosition(Orientation.N, adventurer.getPosition()));
    }

    @Test
    void test_takeTreasure_should_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.N, new Instruction[]{Instruction.A});
        adventurer.takeTreasure();
        Assertions.assertEquals(1, adventurer.getTresureQuantity());
    }

    @Test
    void test_moveForward_should_not_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.S, new Instruction[]{Instruction.A});
        adventurer.moveForward();
        Assertions.assertNotEquals(new Position(1, 0), adventurer.getPosition());
    }

    @Test
    void test_turnLeft_should_not_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.S, new Instruction[]{Instruction.A});
        adventurer.turnLeft();
        Assertions.assertNotEquals(Orientation.W, adventurer.getOrientation());
    }

    @Test
    void test_turnRight_should_not_equal() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 1), Orientation.S, new Instruction[]{Instruction.A});
        adventurer.turnRight();
        Assertions.assertNotEquals(Orientation.E, adventurer.getOrientation());
    }
}