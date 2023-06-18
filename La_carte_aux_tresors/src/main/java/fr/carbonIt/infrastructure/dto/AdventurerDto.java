package fr.carbonIt.infrastructure.dto;

import fr.carbonIt.domain.exceptions.IncorrectDataException;
import fr.carbonIt.domain.models.Adventurer;
import fr.carbonIt.domain.models.Instruction;
import fr.carbonIt.domain.models.Orientation;
import fr.carbonIt.domain.models.Position;

public record AdventurerDto(String name, int horizontalPosition, int verticalPosition, String orientation,
                            String movements) {

    public static Adventurer toAdventurer(AdventurerDto adventurerDto) {
        return new Adventurer(
                adventurerDto.name,
                new Position(adventurerDto.horizontalPosition, adventurerDto.verticalPosition),
                toOrientation(adventurerDto.orientation),
                toInstructions(adventurerDto.movements));
    }

    private static Orientation toOrientation(String orientation) {
        switch (orientation) {
            case "N" -> {
                return Orientation.N;
            }
            case "S" -> {
                return Orientation.S;
            }
            case "E" -> {
                return Orientation.E;
            }
            case "W" -> {
                return Orientation.W;
            }
            default -> throw new IncorrectDataException("Error this orientation doesnt exist :" + orientation);
        }
    }

    private static Instruction[] toInstructions(String movements) {
        Instruction[] instructions = new Instruction[movements.length()];
        for (int i = 0; i < movements.length(); i++) {
            switch (movements.charAt(i)) {
                case 'A' -> instructions[i] = Instruction.A;
                case 'G' -> instructions[i] = Instruction.G;
                case 'D' -> instructions[i] = Instruction.D;
                default -> throw new IncorrectDataException("Error this instruction doesnt exist : " + movements.charAt(i));
            }
        }
        return instructions;
    }
}
