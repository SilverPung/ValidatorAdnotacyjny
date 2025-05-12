package dev.duckyverse.validation;

import java.lang.reflect.Field;
import java.util.Optional;
import dev.duckyverse.annotation.NotNull;
public class NotNullStrategy implements ValidationStrategy {


    /**
     * Metoda validate sprawdza, czy wartość pola jest null.
     * Jeśli tak, zwraca komunikat o błędzie.
     *
     * @param field pole do walidacji
     * @param value wartość pola
     * @return opcjonalny komunikat o błędzie
     */
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            String errorInfo = String.format("Pole %s: %s", field.getName(), annotation.message());
            return Optional.of(errorInfo);
        }
        return Optional.empty();
    }
}
