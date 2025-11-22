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
        addCheck("sizeof", value -> value != null && value.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema<?>> schemas) {
        addCheck("shape", value -> value != null && schemas.entrySet()
                .stream()
                .allMatch(element -> isSchemaValid(element.getValue(), value.get(element.getKey()))));
        return this;
    }

    private <T> boolean isSchemaValid(BaseSchema<T> schema, Object value) {
        @SuppressWarnings("unchecked")
        T typedValue = (T) value;
        return schema.isValid(typedValue);
    }
}
