package dev.duckyverse.validation;

import dev.duckyverse.annotation.NotEmpty;

import java.lang.reflect.Field;
import java.util.Optional;

public class NotEmptyStrategy implements ValidationStrategy{



    /**
     * Metoda validate sprawdza, czy wartość pola jest pusta (null lub pusty ciąg).
     * Jeśli tak, zwraca komunikat o błędzie.
     *
     * @param field pole do walidacji
     * @param value wartość pola
     * @return opcjonalny komunikat o błędzie
     */
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (field.isAnnotationPresent(NotEmpty.class) && value instanceof String strValue) {
            if (strValue.isEmpty()) {
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);
                String errorInfo = String.format("Pole %s: %s", field.getName(), annotation.message());
                return Optional.of(errorInfo);
            }
        }


        return Optional.empty();
    }
}
