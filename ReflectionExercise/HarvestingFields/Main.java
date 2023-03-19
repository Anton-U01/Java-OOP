import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Class clazz = RichSoilLand.class;
        while (!line.equals("HARVEST")){
            Field[] fields = clazz.getDeclaredFields();
            switch (line){
                case "private":
                    Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.printf("private %s %s\n",field.getType().getSimpleName(),field.getName()));
                    break;
                case "protected":
                    Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.printf("protected %s %s\n",field.getType().getSimpleName(),field.getName()));
                    break;
                case "public":
                    Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.printf("public %s %s\n",field.getType().getSimpleName(),field.getName()));
                    break;
                case "all":
                    Arrays.stream(fields)
                            .forEach(field -> System.out.printf("%s %s %s\n",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
                    break;
            }

            line = scan.nextLine();
        }
    }
}
