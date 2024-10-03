package org.example.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public class Transformator {
    public <I, O> O transform(I input, Class<O> target, Map<String, String> bindings) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = input.getClass();

        O instance = target.getDeclaredConstructor().newInstance();

        Field[] clazzFields = clazz.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(clazzFields).forEach(clazzField -> {
            Arrays.stream(targetFields).forEach(targetField -> {
                clazzField.setAccessible(true);
                targetField.setAccessible(true);

                String fieldBinding = bindings.getOrDefault(clazzField.getName(), null);

                if(targetField.getName().equals(fieldBinding) && clazzField.getType().equals(targetField.getType())) {
                    try {
                        targetField.set(instance, clazzField.get(input));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        });

        return instance;
    }

    private boolean validate(Field clazzField, Field targetField) {
        return clazzField.getName().equals(targetField.getName()) && clazzField.getType().equals(targetField.getType());
    }
}
