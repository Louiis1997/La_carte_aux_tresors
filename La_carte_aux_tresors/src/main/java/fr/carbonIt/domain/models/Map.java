package fr.carbonIt.domain.models;

import fr.carbonIt.domain.exceptions.IncorrectDataException;

import java.util.Arrays;
import java.util.Objects;

public class Map {
    private final MapDimension mapDimension;
    private final Mountain[] mountains;
    private final Treasure[] treasures;
    private final Adventurer[] adventurers;

    public Map(MapDimension mapDimension, Mountain[] mountains, Treasure[] treasures, Adventurer[] adventurers) {
        this.mapDimension = mapDimension;
        this.mountains = mountains;
        this.treasures = treasures;
        this.adventurers = adventurers;
    }

    public MapDimension getMapDimension() {
        return mapDimension;
    }

    public Mountain[] getMountains() {
        return mountains;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public Adventurer[] getAdventurers() {
        return adventurers;
    }

    public boolean isPositionAvailable(Position position) {
        return Arrays.stream(mountains).noneMatch(mountain -> mountain.getPosition().equals(position))
                && position.getHorizontalCoordinates() >= 0 && position.getHorizontalCoordinates() < mapDimension.getWidth()
                && position.getVerticalCoordinates() >= 0 && position.getVerticalCoordinates() < mapDimension.getHeight();
    }


    public void moveAdventurers(Adventurer[] adventurers) {
        for (Adventurer adventurer : adventurers) {
            for (Instruction instruction : adventurer.getInstructions()) {
                switch (instruction) {
                    case A -> {
                        Position nextPosition = adventurer.getNextPosition(adventurer.getOrientation(), adventurer.getPosition());
                        if (isPositionAvailable(nextPosition)) {
                            adventurer.moveForward();
                            for (Treasure treasure : treasures) {
                                if (treasure.getPosition().equals(adventurer.getPosition()) && treasure.getNbTreasure() > 0) {
                                    treasure.treasureTaked();
                                    adventurer.takeTreasure();
                                }
                            }
                        }
                    }
                    case G -> adventurer.turnLeft();
                    case D -> adventurer.turnRight();
                    default -> throw new IncorrectDataException("Error this instruction doesnt exist :" + instruction);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map = (Map) o;
        return Objects.equals(mapDimension, map.mapDimension) && Arrays.equals(mountains, map.mountains) && Arrays.equals(treasures, map.treasures) && Arrays.equals(adventurers, map.adventurers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mapDimension);
        result = 31 * result + Arrays.hashCode(mountains);
        result = 31 * result + Arrays.hashCode(treasures);
        result = 31 * result + Arrays.hashCode(adventurers);
        return result;
    }
}
