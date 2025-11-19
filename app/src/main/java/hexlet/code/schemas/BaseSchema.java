package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean isRequired;

    public BaseSchema() {
        this.isRequired = false;
    }

    public abstract boolean isValid(Object o);

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }
}
