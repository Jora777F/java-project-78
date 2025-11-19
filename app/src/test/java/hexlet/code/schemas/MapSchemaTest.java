package hexlet.code.schemas;

import hexlet.code.Validator;
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

    @DisplayName(value = "Должен вернуть true, когда передаются валидные значения.")
    @Test
    public void shouldReturnTrueWhenShapeValid() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human = new HashMap<>();
        human.put("name", "John");
        human.put("age", Integer.MAX_VALUE);
        assertTrue(schema.isValid(human));
    }

    @DisplayName(value = "Должен вернуть false, когда передаются невалидные значения.")
    @Test
    public void shouldReturnFalseWhenShapeInvalidValue() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);

        Map<String, Object> human = new HashMap<>();
        human.put("name", "");
        human.put("age", -1);
        assertFalse(schema.isValid(human));
    }
}
