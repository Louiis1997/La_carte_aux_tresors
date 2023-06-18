package fr.carbonIt.domain.models;

public enum Orientation {
    N,
    S,
    E,
    W;

    @Override
    public String toString() {
        return switch (this) {
            case N -> "N";
            case S -> "S";
            case E -> "E";
            case W -> "W";
        };
    }
}
