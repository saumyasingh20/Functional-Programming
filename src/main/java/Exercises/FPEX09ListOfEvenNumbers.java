package Exercises;

import java.util.List;
import java.util.stream.Collectors;

public class FPEX09ListOfEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
        List<Integer> evenNumbers = findEven(numbers);
        System.out.println(evenNumbers);
    }

    private static List<Integer> findEven(List<Integer> numbers) {
        return numbers.stream().filter(num -> num%2==0).collect(Collectors.toList());
    }

}
