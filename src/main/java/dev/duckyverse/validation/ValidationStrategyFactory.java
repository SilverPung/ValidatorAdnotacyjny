package dev.duckyverse.validation;

import dev.duckyverse.annotation.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ValidationStrategyFactory {
    // fragment Class<? extends Annotation> określa, że kluczem mapy mogą być
// tylko klasy, które rozszerzają lub implementują interfejs Annotation
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