package dev.duckyverse.validation;

import dev.duckyverse.annotation.Size;

import java.lang.reflect.Field;
import java.util.Optional;

public class SizeStrategy implements ValidationStrategy {
    @Override
    public Optional<String> validate(Field field, Object value) {
        if (field.isAnnotationPresent(Size.class) && value instanceof String strValue) {
            Size annotation = field.getAnnotation(Size.class);
            int min = annotation.min();
            int max = annotation.max();

            if (strValue.length() < min || strValue.length() > max) {
                String errorInfo = String.format("Pole %s: %s", field.getName(), annotation.message());
                return Optional.of(errorInfo);
            }
        }
        return Optional.empty();
    }
}
