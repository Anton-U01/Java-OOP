package EncapsulationLab.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age,double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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
