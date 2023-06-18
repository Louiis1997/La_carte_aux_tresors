package fr.carbonIt.domain.models;

import fr.carbonIt.domain.exceptions.NotEnoughTreasureException;

import java.util.Objects;

public class Treasure {
    private final Position position;
    private int nbTreasure;

    public Treasure(Position position, int nbTreasure) {
        this.position = position;
        this.nbTreasure = nbTreasure;
    }

    public Position getPosition() {
        return position;
    }

    public int getNbTreasure() {
        return nbTreasure;
    }

    void treasureTaked() {
        if (this.nbTreasure < 0) {
            throw new NotEnoughTreasureException("Not enough treasure to take");
        }
        nbTreasure--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return nbTreasure == treasure.nbTreasure && Objects.equals(position, treasure.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, nbTreasure);
    }

    @Override
    public String toString() {
        return "T - " + position.toString() + " - " + nbTreasure;
    }
}
