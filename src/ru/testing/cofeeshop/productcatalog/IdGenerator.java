package ru.testing.cofeeshop.productcatalog;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class IdGenerator {

    public static void generateAndSetId(Object object, Long lastId) {
        try {
            List<Field> fields = getAllFields(new LinkedList<Field>(), object.getClass());
            Field field = fields.stream().filter(field1 -> field1.getName().equalsIgnoreCase("id")).findFirst().get();
            // Allow modification on the field
            field.setAccessible(true);
            // Get
            final Object oldValue = field.get(object);
            // Sets the field to the new value
            field.set(object, lastId + 1);
            // Disable modification on the field
            field.setAccessible(false);

        } catch (NoSuchElementException | IllegalAccessException | IllegalArgumentException ex) {
            System.err.println(
                    String.format("Can't generate id for object class %s with lastId %d with error %s", object.getClass(), lastId, ex.getMessage()));
        }
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }
}
