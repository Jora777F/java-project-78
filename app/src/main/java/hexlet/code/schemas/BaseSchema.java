package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected final void addCheck(String name, Predicate<T> check) {
        checks.put(name, check);
    }

    public final boolean isValid(Object value) {
        @SuppressWarnings("unchecked")
        T typedValue = (T) value;

        for (Predicate<T> validate : checks.values()) {
            if (!validate.test(typedValue)) {
                return false;
            }
        }
        return true;
    }
}
