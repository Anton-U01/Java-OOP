package InheritanceExercise.animals;

public class Kitten extends Cat{
    private static final String KITTEN_GENDER = "Female";

    public Kitten(String name, int age,String gender) {
        super(name, age, KITTEN_GENDER);
    }
    @Override
    public void produceSound(){
        System.out.println("Meow");
    }
}
