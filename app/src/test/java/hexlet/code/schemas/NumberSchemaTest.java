package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberSchemaTest {

    public static final int ZERO = 0;
    public static final int TEN = 10;
    public static final int MINUS_TWO = -2;
    public static final int TWO = 2;
    public static final int FIVE = 5;
    public static final int ELEVEN = 11;

    @DisplayName(value = "Должен выполнить валидацию, когда указаны положительные числа и не используется required.")
    @Test
    void shouldCorrectValidationWhenIsValidWithPositiveNumberAndNotRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(MINUS_TWO));

        schema.positive();

        assertFalse(schema.isValid(MINUS_TWO));
        assertFalse(schema.isValid(ZERO));
        assertTrue(schema.isValid(TEN));
        assertTrue(schema.isValid(null));
    }

    @DisplayName(value = "Должен вернуть false, когда вызван метод required.")
    @Test
    void shouldReturnTrueWhenRequiredCall() {
        NumberSchema schema = new NumberSchema();
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @DisplayName(value = "Должен выполнить валидацию, когда задан диапазон значений.")
    @Test
    void shouldCorrectValidationWhenIsValidWithRangeNumber() {
        Validator v = new Validator();
        NumberSchema schema = v.number().range(ZERO, TEN);

        assertTrue(schema.isValid(TWO));
        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(ZERO));
        assertFalse(schema.isValid(MINUS_TWO));
        assertFalse(schema.isValid(ELEVEN));
    }
}
