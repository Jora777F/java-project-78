package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class StringSchema extends BaseSchema<String> {

    private boolean isRequired;
    private int minLength;
    private final List<String> rules;

    public StringSchema() {
        super();
        this.minLength = -1;
        this.rules = new ArrayList<>();
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.rules.add(substring);
        return this;
    }

    @Override
    public boolean isValid(Object object) {
        if (!this.isRequired && object == null) {
            return true;
        }

        if (!(object instanceof String s)) {
            return false;
        }

        boolean required = checkRequired(s);
        boolean length = checkMinLength(s);
        boolean containsRules = checkRules(s);

        return required && length && containsRules;
    }

    @Override
    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    private boolean checkRules(String s) {
        if (rules.isEmpty()) {
            return true;
        }

        boolean result = true;
        for (String rule : rules) {
            if (!s.contains(rule)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkRequired(String s) {
        if (isRequired) {
            return !s.isEmpty();
        }
        return true;
    }

    private boolean checkMinLength(String s) {
        if (minLength != -1) {
            return s.length() >= minLength;
        }
        return true;
    }
}
