package hexlet.code.schemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberSchemaTest {

    public static final int ZERO = 0;
    public static final int TEN = 10;
    public static final int FIVE = 5;
    public static final int ELEVEN = 11;


    @DisplayName(value = "Должен вернуть true, когда метод required не вызван.")
    @Test
    void shouldReturnTrueWhenRequiredNotCall() {
        NumberSchema schema = new NumberSchema();
        schema.positive().range(ZERO, TEN);
        assertTrue(schema.isValid(null));

        assertFalse(schema.isValid(ELEVEN));
        assertTrue(schema.isValid(FIVE));
    }

    @DisplayName(value = "Должен вернуть false, когда вызван метод required.")
    @Test
    void shouldReturnTrueWhenRequiredCall() {
        NumberSchema schema = new NumberSchema();
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @DisplayName(value = "Должен вернуть false, когда передается неверный тип.")
    @Test
    void shouldReturnFalseWhenInvalidType() {
        NumberSchema schema = new NumberSchema();
        assertFalse(schema.isValid("not a number"));
    }
}
