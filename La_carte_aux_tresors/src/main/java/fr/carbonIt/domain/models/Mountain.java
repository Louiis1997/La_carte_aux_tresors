package fr.carbonIt.domain.models;

import java.util.Objects;

public class Mountain {
    private final Position position;

    public Mountain(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mountain mountain = (Mountain) o;
        return Objects.equals(position, mountain.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "M - " +  position.toString();
    }
}
