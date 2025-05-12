package dev.duckyverse.validation;

import java.lang.reflect.Field;
import java.util.Optional;


/**
 * Interfejs walidacyjny, który definiuje metodę do walidacji wartości pola.
 * Każda strategia walidacji powinna implementować ten interfejs.
 */
public interface ValidationStrategy {
    Optional<String> validate(Field field, Object value);
}
