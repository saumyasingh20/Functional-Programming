package Exercises;

import java.util.List;

public class FPEX01 {
    public static void main(String[] args) {

        printOddNumbers(List.of(78,59,21,5,23,12,75,59));
    }

    private static void printOddNumbers(List<Integer> integers) {
        integers.stream()
                .filter(num -> num%2==1)
                .forEach(System.out::println);
    }
}
