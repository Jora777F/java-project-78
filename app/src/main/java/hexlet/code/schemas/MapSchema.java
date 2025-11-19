package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private int sizeOf;
    private Map<String, BaseSchema<?>> schemas;

    public MapSchema() {
        super();
        this.sizeOf = -1;
    }

    @Override
    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    @Override
    public boolean isValid(Object o) {
        if (!isRequired && o == null) {
            return true;
        }
        if (!(o instanceof Map map)) {
            return false;
        }

        if (schemas != null && !validateShape(map)) {
            return false;
        }

        return checkSizeOf(map);
    }

    private boolean validateShape(Map map) {
        for (Map.Entry<String, BaseSchema<?>> entry : schemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema<?> schema = entry.getValue();
            Object value = map.get(key);
            if (!schema.isValid(value)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSizeOf(Map map) {
        if (sizeOf == -1) {
            return true;
        }
        return map.size() == sizeOf;
    }

    public MapSchema sizeof(int sizeof) {
        this.sizeOf = sizeof;
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema<?>> newSchemas) {
        this.schemas = new HashMap<>();
        this.schemas.putAll(newSchemas);
        return this;
    }
}
