package EncapsulationLab.ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 460.0){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void setFirstName(String firstName) {
        if(firstName.length() < 3 ){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(double percentBonus){
        double bonus1 = 0;
        if(this.age < 30){
            bonus1 = this.getSalary() * percentBonus / 200;
        } else {
            bonus1 = this.getSalary() * percentBonus / 100;
        }
        this.setSalary(this.getSalary() + bonus1);
    }

    @Override
    public String toString(){
        return String.format("%s %s gets %.2f leva",getFirstName(),getLastName(),getSalary());
    }
}
