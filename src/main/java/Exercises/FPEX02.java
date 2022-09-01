package Exercises;

import java.util.List;

public class FPEX02 {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        printCourses(courses);
    }

    private static void printCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }
}
