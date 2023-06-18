package fr.carbonIt.infrastructure.output;

import fr.carbonIt.domain.models.Map;

public interface OutputGenerator {
    String generateOutput(Map map);
}
