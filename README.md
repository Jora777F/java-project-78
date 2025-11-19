### Hexlet tests and linter status:
[![Actions Status](https://github.com/Jora777F/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Jora777F/java-project-78/actions)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Jora777F_java-project-78&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Jora777F_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Jora777F_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Jora777F_java-project-78)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Jora777F_java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Jora777F_java-project-78)

## Валидатор данных
Валидатор данных - это библиотека, с помощью которой можно проверить корректность любых данных.
Прежде всего, речь идет о данных форм, заполняемых пользователями.

Поддерживается три типа данных:
`String`, `Integer` и `Map`. Чтобы начать работу с библиотекой,
просто создайте новый объект Validator:
```java
Validator v = new Validator();
```

### String Schema
Схема String содержит три метода проверки:

- required() - строка не может быть `null` или пустой
- minLength() - длина строки должна быть больше, чем указано в ограничителе, передаваемом в качестве параметра (или такой же длины)
- contains() - строка должна содержать подстроку, передаваемую в качестве параметра

### Number Schema
Схема Number содержит три метода проверки:

- required() - число не может быть null, передаваемые данные должны иметь тип `Integer`
- positive() - число должно быть больше чем ноль
- range() - число должно быть больше минимального значения, передаваемого в качестве параметра, и меньше максимального значения

### Map Schema
Схема Map содержит три метода проверки:

- required() - передаваемое значение не должно быть равно null и должно иметь тип `Map`
- sizeof() - количество пар ключ-значение не должно быть меньше переданного значения
- shape() - позволяет описать проверку значений для каждого ключа объекта `Map`