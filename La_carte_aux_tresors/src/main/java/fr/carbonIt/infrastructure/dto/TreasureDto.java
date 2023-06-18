package fr.carbonIt.infrastructure.dto;

import fr.carbonIt.domain.models.Position;
import fr.carbonIt.domain.models.Treasure;

public record TreasureDto(int horizontalPosition, int verticalPosition, int treasureNumber) {

    public static Treasure toTreasure(TreasureDto treasureDto) {
        return new Treasure(new Position(treasureDto.horizontalPosition, treasureDto.verticalPosition), treasureDto.treasureNumber);
    }
}
