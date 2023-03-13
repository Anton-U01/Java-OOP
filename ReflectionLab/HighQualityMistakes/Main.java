package ReflectionLab.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class clazz = Reflection.class;
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(field -> System.out.printf("%s must be private!\n",field.getName()));
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(getter -> !Modifier.isPublic(getter.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.printf("%s have to be public!\n",getter.getName()));
        Arrays.stream(methods).filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .filter(setter -> !Modifier.isPrivate(setter.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.printf("%s have to be private!",setter.getName()));
    }
}
