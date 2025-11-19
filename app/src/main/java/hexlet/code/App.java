package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {

    private static final String TEXT = "what does the fox say";

    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        // Пока не вызван метод required(), null и пустая строка считаются валидным
        System.out.println(schema.isValid("")); // true
        System.out.println(schema.isValid(null)); // true

        schema.required();

        System.out.println(schema.isValid(null)); // false
        System.out.println(schema.isValid("")); // false
        System.out.println(schema.isValid(TEXT)); // true
        System.out.println(schema.isValid("hexlet")); // true

        System.out.println(schema.contains("wh").isValid(TEXT)); // true
        System.out.println(schema.contains("what").isValid(TEXT)); // true
        System.out.println(schema.contains("whatthe").isValid(TEXT)); // false

        System.out.println(schema.isValid(TEXT)); // false
        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

        // Если один валидатор вызывался несколько раз
        // то последний имеет приоритет (перетирает предыдущий)
        StringSchema schema1 = v.string();
        System.out.println(schema1.minLength(10).minLength(4).isValid("Hexlet")); // true
    }
}
