package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        addCheck("typeData", value -> value instanceof String || value == null);
    }

    public StringSchema minLength(int number) {
        addCheck("minLength", value -> value.length() >= number);
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", value -> value.contains(substring));
        return this;
    }

    public StringSchema required() {
        addCheck("required", value -> value instanceof String && !value.isEmpty());
        return this;
    }
}
