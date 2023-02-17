package WorkingwithAbstractionLab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem()
    {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void getInfo(String[]args)
    {

        if (args[0].equals("Create"))
        {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade =Double.parseDouble(args[3]);
            Student student = new Student(name,age,grade);
            students.putIfAbsent(name,student);
        }
        else if (args[0].equals("Show"))
        {
            String name = args[1];
            if (students.containsKey(name))
            {
                Student student = students.get(name);
                StringBuilder view = new StringBuilder(String.format("%s is %s years old.",student.getName(),student.getAge()));

                if (student.getGrade() >= 5.00)
                {
                    view.append(" Excellent student.");
                }
                else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
                {
                    view.append(" Average student.");
                }
                else
                {
                    view.append( " Very nice person.");
                }

                System.out.println(view);
            }
        }
    }
}
