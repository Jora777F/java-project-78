package hexlet.code.schemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    @DisplayName(value = "Должен вернуть true, когда передается NULL.")
    @Test
    void shouldReturnTrueWhenIsValidWithNull() {
        MapSchema schema = new MapSchema();
        boolean isValid = schema.isValid(null);
        assertTrue(isValid);
    }

    @DisplayName(value = "Должен вернуть false, когда вызывается required и передается NULL.")
    @Test
    void shouldReturnFalseWhenIsValidMapObjectAndRequired() {
        MapSchema schema = new MapSchema();
        schema.required();
        boolean isValid = schema.isValid(null);
        assertFalse(isValid);
    }

    @DisplayName(value = "Должен вернуть false, когда количество пар-ключ значений не совпадает размеру.")
    @Test
    void shouldReturnFalseWhenMapObjectAndInvalidSizeOf() {
        MapSchema schema = new MapSchema().sizeof(2);
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        boolean isValid = schema.isValid(map);
        assertFalse(isValid);
    }
}
