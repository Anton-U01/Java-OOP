package InheritanceExercise.animals;

public class Tomcat extends Cat{
    private static final String TOMCAT_GENDER = "Male";

    public Tomcat(String name, int age,String gender) {
        super(name, age, TOMCAT_GENDER);
    }
    @Override
    public void produceSound(){
        System.out.println("MEOW");
    }
}
