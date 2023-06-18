package fr.carbonIt.domain.models;

import java.util.Objects;

public class Position {
    private final int horizontalCoordinates;
    private final int verticalCoordinates;

    public int getHorizontalCoordinates() {
        return horizontalCoordinates;
    }

    public int getVerticalCoordinates() {
        return verticalCoordinates;
    }

    public Position(int horizontalCoordinates, int verticalCoordinates) {
        this.horizontalCoordinates = horizontalCoordinates;
        this.verticalCoordinates = verticalCoordinates;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return horizontalCoordinates == position.horizontalCoordinates && verticalCoordinates == position.verticalCoordinates;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalCoordinates, verticalCoordinates);
    }

    @Override
    public String toString() {
        return horizontalCoordinates + " - " + verticalCoordinates;
    }
}
