package ReflectionExercise.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt boxInt = (BlackBoxInt) constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        while (!line.equals("END")){
            String command = line.split("_")[0];
            int value = Integer.parseInt(line.split("_")[1]);
            switch (command){
                case "add":
                    executeCommand(clazz, boxInt, innerValue, value,"add");
                    break;
                case "subtract":
                    executeCommand(clazz, boxInt, innerValue, value,"subtract");
                    break;
                case "multiply":
                    executeCommand(clazz, boxInt, innerValue, value,"multiply");
                    break;
                case "divide":
                    executeCommand(clazz, boxInt, innerValue, value,"divide");
                    break;
                case "leftShift":
                    executeCommand(clazz, boxInt, innerValue, value,"leftShift");
                    break;
                case "rightShift":
                    executeCommand(clazz, boxInt, innerValue, value,"rightShift");
                    break;
            }
            line = scan.nextLine();
        }
    }

    private static void executeCommand(Class<BlackBoxInt> clazz, BlackBoxInt boxInt, Field innerValue, int value,String command) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = clazz.getDeclaredMethod(command,int.class);
        method.setAccessible(true);
        method.invoke(boxInt, value);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(boxInt));
    }
}
