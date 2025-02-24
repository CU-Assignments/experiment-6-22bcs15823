import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 85),
            new Student("Emma", 70),
            new Student("Michael", 90),
            new Student("Sophia", 65)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75) // Filter students scoring above 75%
            .sorted(Comparator.comparingDouble(s -> -s.marks)) // Sort in descending order
            .map(s -> s.name) // Extract names
            .collect(Collectors.toList());

        topStudents.forEach(System.out::println);
    }
}
