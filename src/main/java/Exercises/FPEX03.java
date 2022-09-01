package Exercises;

import java.util.List;

public class FPEX03 {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        printCoursesWithSpring(courses);
    }

    private static void printCoursesWithSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

}
