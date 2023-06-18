package fr.carbonIt.infrastructure.output;

import fr.carbonIt.domain.models.Map;

import java.util.Arrays;

public class MapTxtOutputGenerator implements OutputGenerator{
    @Override
    public String generateOutput(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("C - ").append(map.getMapDimension().toString()).append("\n");
        Arrays.stream(map.getMountains()).map(mountain -> mountain.toString() + "\n").forEach(stringBuilder::append);
        Arrays.stream(map.getTreasures()).filter(treasure -> treasure.getNbTreasure() > 0).map(treasure -> treasure.toString() + "\n").forEach(stringBuilder::append);
        Arrays.stream(map.getAdventurers()).map(adventurer -> adventurer.toString() + "\n").forEach(stringBuilder::append);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
