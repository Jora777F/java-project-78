package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean isRequired;

    public BaseSchema() {
        this.isRequired = false;
    }

    public abstract boolean isValid(Object o);

    public void required() {
        this.isRequired = true;
    }
}
