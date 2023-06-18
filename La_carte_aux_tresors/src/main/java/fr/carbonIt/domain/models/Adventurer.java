package fr.carbonIt.domain.models;

import fr.carbonIt.domain.exceptions.IncorrectDataException;

import java.util.Arrays;
import java.util.Objects;

public class Adventurer {
    private final String name;
    private Position position;
    private Orientation orientation;
    private final Instruction[] instructions;
    private int tresureQuantity;

    public Adventurer(String name, Position position, Orientation orientation, Instruction[] instructions) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.instructions = instructions;
        this.tresureQuantity = 0;
    }

    public void moveForward() {
        switch (orientation) {
            case N -> position = new Position(position.getHorizontalCoordinates(), position.getVerticalCoordinates() - 1);
            case S -> position = new Position(position.getHorizontalCoordinates(), position.getVerticalCoordinates() + 1);
            case E -> position = new Position(position.getHorizontalCoordinates() + 1, position.getVerticalCoordinates());
            case W -> position = new Position(position.getHorizontalCoordinates() - 1, position.getVerticalCoordinates());
            default -> throw new IncorrectDataException("Error this orientation doesnt exist :" + orientation);
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case N -> orientation = Orientation.W;
            case S -> orientation = Orientation.E;
            case E -> orientation = Orientation.N;
            case W -> orientation = Orientation.S;
            default -> throw new IncorrectDataException("Error this orientation doesnt exist :" + orientation);
        }
    }

    public void turnRight() {
        switch (orientation) {
            case N -> orientation = Orientation.E;
            case S -> orientation = Orientation.W;
            case E -> orientation = Orientation.S;
            case W -> orientation = Orientation.N;
            default -> throw new IncorrectDataException("Error this orientation doesnt exist :" + orientation);
        }
    }

    public Position getNextPosition(Orientation orientation, Position position) {
        switch (orientation) {
            case N -> {
                return new Position(position.getHorizontalCoordinates(), position.getVerticalCoordinates() - 1);
            }
            case S -> {
                return new Position(position.getHorizontalCoordinates(), position.getVerticalCoordinates() + 1);
            }
            case E -> {
                return new Position(position.getHorizontalCoordinates() + 1, position.getVerticalCoordinates());
            }
            case W -> {
                return new Position(position.getHorizontalCoordinates() - 1, position.getVerticalCoordinates());
            }
            default -> throw new IncorrectDataException("Error this orientation doesnt exist :" + orientation);
        }
    }

    public void takeTreasure() {
        tresureQuantity++;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public int getTresureQuantity() {
        return tresureQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adventurer that = (Adventurer) o;
        return tresureQuantity == that.tresureQuantity && Objects.equals(name, that.name) && Objects.equals(position, that.position) && orientation == that.orientation && Arrays.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, position, orientation, tresureQuantity);
        result = 31 * result + Arrays.hashCode(instructions);
        return result;
    }

    @Override
    public String toString() {
        return "A - " + name +
                " - " + position.toString() +
                " - " + orientation.toString() +
                " - " + tresureQuantity;
    }
}
