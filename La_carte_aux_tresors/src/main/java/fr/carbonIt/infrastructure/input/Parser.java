package fr.carbonIt.infrastructure.input;

import fr.carbonIt.domain.models.Map;

public interface Parser {
    Map parseFileToDomain(String content);
}
