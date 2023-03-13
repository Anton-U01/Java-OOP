package ReflectionLab.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);
        Object reflection = clazz.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}
