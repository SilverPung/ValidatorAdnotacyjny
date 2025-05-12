package dev.duckyverse.validation;

import dev.duckyverse.annotation.Email;

import java.lang.reflect.Field;
import java.util.Optional;

public class EmailStrategy implements ValidationStrategy {



    /**
     * Metoda walidująca adres e-mail.
     * Sprawdza, czy wartość pola jest zgodna z formatem adresu e-mail.
     *
     * @param field pole do walidacji
     * @param value wartość pola
     * @return opcjonalny komunikat o błędzie, jeśli walidacja nie powiodła się
     */
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (field.isAnnotationPresent(Email.class) && value instanceof String strValue) {
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!strValue.matches(emailRegex)) {
                Email annotation = field.getAnnotation(Email.class);
                String errorInfo = String.format("Pole %s: %s", field.getName(), annotation.message());
                return Optional.of(errorInfo);
            }
        }
        return Optional.empty();
    }
}
