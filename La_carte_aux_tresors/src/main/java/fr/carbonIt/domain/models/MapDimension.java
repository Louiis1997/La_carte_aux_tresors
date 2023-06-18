package fr.carbonIt.domain.models;

import fr.carbonIt.domain.exceptions.IncorrectDataException;

import java.util.Objects;

public class MapDimension {
    private final int width;
    private final int height;

    public MapDimension(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IncorrectDataException("Map dimension should be positive and greater than 0");
        }
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapDimension that = (MapDimension) o;
        return width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return width + " - " + height;
    }
}
