package hexlet.code.schemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StringSchemaTest {

    @DisplayName(value = "Должен вернуть true, когда передается NULL в isValid.")
    @Test
    void shouldReturnTrueWhenIsValidWithNull() {
        StringSchema schema = new StringSchema();
        assertTrue(schema.isValid(null));
    }

    @DisplayName(value = "Должен вернуть false, когда передается не строковый объект в isValid.")
    @Test
    void shouldReturnFalseWhenIsValidWithNonString() {
        StringSchema schema = new StringSchema();
        assertFalse(schema.isValid(123));
    }

    @DisplayName(value = "Должен вернуть true, когда передается пустая строка в isValid.")
    @Test
    public void shouldReturnTrueWhenIsValidWithEmptyString() {
        StringSchema schema = new StringSchema();
        assertTrue(schema.isValid(""));
    }

    @DisplayName(value = "Должен вернуть , когда вызывается required и передается пустая строка.")
    @Test
    public void shouldReturnFalseWhenCalledRequiredAndIsValidWithEmptyString() {
        StringSchema schema = new StringSchema();
        schema.required();
        assertTrue(schema.isValid(""));
    }

    @DisplayName(value = "Должен вернуть true/false, когда установлен минимальный размер строки.")
    @Test
    public void shouldReturnFalseOrTrueWhenIsValidHasMinLength() {
        StringSchema schema = new StringSchema();
        schema.minLength(3);
        assertFalse(schema.isValid("ab"));
        assertTrue(schema.isValid("abc"));
    }

    @DisplayName(value = "Должен проверить схему, когда заданы все проверки.")
    @Test
    public void shouldCheckedSchemaWhenIsValidHasAllChecks() {
        StringSchema schema = new StringSchema();
        schema.required();
        schema.minLength(5);
        schema.contains("world");
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("hello"));
        assertFalse(schema.isValid("worli"));
        assertFalse(schema.isValid("hello "));
        assertFalse(schema.isValid("helwo"));
        assertTrue(schema.isValid("hello world"));
    }
}
