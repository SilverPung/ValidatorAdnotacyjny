package dev.duckyverse.validation;

import dev.duckyverse.annotation.NrIndeksu;

import java.lang.reflect.Field;
import java.util.Optional;

public class NrIndeksuStrategy implements ValidationStrategy{


    /**
     * Metoda validate sprawdza, czy wartość pola jest poprawnym numerem indeksu.
     * Numer indeksu powinien mieć 8 cyfr.
     * Jeśli nie, zwraca komunikat o błędzie.
     *
     * @param field pole do walidacji
     * @param value wartość pola
     * @return opcjonalny komunikat o błędzie
     */
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (field.isAnnotationPresent(NrIndeksu.class) && value != null) {
            String nrIndeksu = value.toString();
            if (!nrIndeksu.matches("\\d{8}")) {
                NrIndeksu annotation = field.getAnnotation(NrIndeksu.class);
                String errorInfo = String.format("Pole %s: %s", field.getName(), annotation.message());
                return Optional.of(errorInfo);
            }
        }
        return Optional.empty();
    }
}
