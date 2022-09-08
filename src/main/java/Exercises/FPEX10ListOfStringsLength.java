package Exercises;

import java.util.List;
import java.util.stream.Collectors;

public class FPEX10ListOfStringsLength {
    public static void main(String[] args) {
        List<String> courses = List.of("Docker","Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Kubernetes");
        List<Integer> length = findLength(courses);
        System.out.println(length);
    }

    private static List<Integer> findLength(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList());
    }


}
