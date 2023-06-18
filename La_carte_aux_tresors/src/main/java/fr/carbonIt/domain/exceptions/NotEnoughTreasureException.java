package fr.carbonIt.domain.exceptions;

public class NotEnoughTreasureException extends RuntimeException {
    public NotEnoughTreasureException(String message) {
        super(message);
    }
}
