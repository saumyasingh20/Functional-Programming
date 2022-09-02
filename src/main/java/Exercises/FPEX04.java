package Exercises;

import java.util.List;

public class FPEX04 {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        //printCoursesWithAtLeastFourLetters(courses);
        printNumOfCharacters(courses);
    }

    private static void printCoursesWithAtLeastFourLetters(List<String> courses) {

        courses.stream()
                .filter(course -> course.length()>=4)
                .forEach(System.out::println);
    }

    private static void printNumOfCharacters(List<String> courses) {

        courses.stream()
                .map(course -> course + " has " + course.length() + " characters")
                .forEach(System.out::println);
    }
}
