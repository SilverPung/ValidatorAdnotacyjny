package dev.duckyverse.validation;

import dev.duckyverse.annotation.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ValidationStrategyFactory {
    /**
     * Factory class dla tworzenia strategii walidacji.
     * Zawiera mapę strategii walidacji, które są przypisane do odpowiednich adnotacji.
     */
    private static final Map<Class<? extends Annotation>, ValidationStrategy>
            strategies = new HashMap<>();
    static {
        strategies.put(NotNull.class, new NotNullStrategy());
        strategies.put(NotEmpty.class, new NotEmptyStrategy());
        strategies.put(Size.class, new SizeStrategy());
        strategies.put(Email.class, new EmailStrategy());
        strategies.put(NrIndeksu.class, new NrIndeksuStrategy());
    }
    private ValidationStrategyFactory() {
    }
    public static ValidationStrategy getStrategy(Annotation annotation) {
        return strategies.get(annotation.annotationType());
    }
}