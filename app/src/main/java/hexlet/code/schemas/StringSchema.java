package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {

    private boolean isRequired;
    private int minLength;
    private final List<String> rules;

    public StringSchema() {
        this.isRequired = false;
        this.minLength = -1;
        this.rules = new ArrayList<>();
    }

    public void required() {
        this.isRequired = true;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.rules.add(substring);
        return this;
    }

    public boolean isValid(Object object) {
        if (!this.isRequired && object == null) {
            return true;
        }

        if (!(object instanceof String)) {
            return false;
        }

        boolean required = checkRequired((String) object);
        boolean length = checkMinLength((String) object);
        boolean containsRules = checkRules((String) object);

        return required && length && containsRules;
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
