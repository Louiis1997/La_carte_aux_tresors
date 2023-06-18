package fr.carbonIt.infrastructure.dto;

import fr.carbonIt.domain.models.Mountain;
import fr.carbonIt.domain.models.Position;

public record MountainDto(int horizontalPosition, int verticalPosition) {

    public static Mountain toMountain(MountainDto mountainDto) {
        return new Mountain(new Position(mountainDto.horizontalPosition, mountainDto.verticalPosition));
    }
}
