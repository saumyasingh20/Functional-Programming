package Programming;

import java.util.Comparator;
import java.util.List;

public class FP04ComparatorsToSortStreams {
    public static void main(String[] args) {

        List<String> courses = List.of("Docker","Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Kubernetes");
        sortStreamUsingComparator(courses);

    }

    private static void sortStreamUsingComparator(List<String> courses) {
       // courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }
}
