package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private int sizeOf;

    public MapSchema() {
        super();
        this.sizeOf = -1;
    }

    @Override
    public boolean isValid(Object o) {
        if (!isRequired && o == null) {
            return true;
        }
        if (!(o instanceof Map map)) {
            return false;
        }
        return checkSizeOf(map);
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
}
