package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema() {
        addCheck("typeData", value -> value instanceof Map<?, ?> || value == null);
    }

    public MapSchema required() {
        addCheck("required", value -> value instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> value.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck("shape", value -> schemas.entrySet()
                .stream()
                .allMatch(element -> element.getValue()
                        .isValid(((Map<?, ?>) value)
                                .get(element.getKey()))));
        return this;
    }
}
