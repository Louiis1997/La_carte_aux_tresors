package fr.carbonIt.infrastructure.dto;

import fr.carbonIt.domain.models.MapDimension;

public record MapDto(int width, int height) {
    public MapDimension toMap(MapDto mapDto) {
        return new MapDimension(mapDto.width, mapDto.height);
    }
}
