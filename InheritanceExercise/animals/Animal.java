package InheritanceExercise.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 1){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equals("Male") || gender.equals("Female")){
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }

    }

    @Override
    public String toString(){
        return String.format("%s%n%s %d %s",this.getClass().getSimpleName(),name,age,gender);
    }
    protected abstract void produceSound();
}
