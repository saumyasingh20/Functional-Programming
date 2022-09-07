package Exercises;

import java.util.List;

public class SumOfOddNumbersInList {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,3,5,0,9,89,4);
        int sum = sumOfOddNumbersInList(numbers);
        System.out.println("sum of odd numbers = " +sum);
    }

    private static int sumOfOddNumbersInList(List<Integer> numbers) {
        return numbers.stream().filter(x->x%2==1).reduce(0,Integer::sum);
    }
}
