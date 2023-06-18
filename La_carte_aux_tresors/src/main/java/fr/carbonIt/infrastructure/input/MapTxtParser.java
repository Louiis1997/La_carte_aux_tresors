package fr.carbonIt.infrastructure.input;

import fr.carbonIt.domain.exceptions.IncorrectDataException;
import fr.carbonIt.domain.models.*;
import fr.carbonIt.infrastructure.dto.AdventurerDto;
import fr.carbonIt.infrastructure.dto.MapDto;
import fr.carbonIt.infrastructure.dto.MountainDto;
import fr.carbonIt.infrastructure.dto.TreasureDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapTxtParser implements Parser {
    @Override
    public Map parseFileToDomain(String content) {
        if (content == null) {
            throw new IllegalArgumentException("The file is empty");
        }
        String[] lines = Arrays.stream(content.split("\n")).map(String::trim).toArray(String[]::new);
        MapDto mapDto = null;
        List<MountainDto> mountainDtos = new ArrayList<>();
        List<TreasureDto> treasureDtos = new ArrayList<>();
        List<AdventurerDto> adventurerDtos = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] split;
            if (line.startsWith("C")) {
                split = line.split(" - ");
                try {
                    mapDto = new MapDto(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                } catch (NumberFormatException e) {
                    throw new IncorrectDataException("Map dimension should be 2 numbers like : 3 - 4");
                }
            }
            else if (line.startsWith("M")) {
                split = line.split(" - ");
                try {
                    mountainDtos.add(new MountainDto(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                } catch (NumberFormatException e) {
                    throw new IncorrectDataException("Mountain position should be 2 numbers like : 3 - 4");
                }
            }
            else if (line.startsWith("T")) {
                split = line.split(" - ");
                try {
                    treasureDtos.add(new TreasureDto(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
                } catch (NumberFormatException e) {
                    throw new IncorrectDataException("Treasure should be compose of 3 numbers like : 3 - 4 - 2 where 2 is the number of treasures");
                }
            }
            else if (line.startsWith("A")) {
                split = line.split(" - ");
                try {
                    adventurerDtos.add(new AdventurerDto(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], split[5]));
                } catch (NumberFormatException e) {
                    throw new IncorrectDataException("Adventurer position should be 2 numbers like : 1 - 1");
                }
            }
            else {
                throw new IllegalArgumentException("The file is not well formatted, each line should start with C, M, T or A");
            }
        }
        assert mapDto != null;
        return new Map(
                mapDto.toMap(mapDto),
                mountainDtos.stream().map(MountainDto::toMountain).toArray(Mountain[]::new),
                treasureDtos.stream().map(TreasureDto::toTreasure).toArray(Treasure[]::new),
                adventurerDtos.stream().map(AdventurerDto::toAdventurer).toArray(Adventurer[]::new));
    }
}
