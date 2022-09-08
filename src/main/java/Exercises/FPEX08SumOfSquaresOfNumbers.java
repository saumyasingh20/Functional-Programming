package Exercises;

import java.util.List;

public class FPEX08SumOfSquaresOfNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,3,5,0,9,89,4);
        int sum = sumOfSquaresOfList(numbers);
        System.out.println("sum of squares= " +sum);
    }

    private static int sumOfSquaresOfList(List<Integer> numbers) {
        return numbers.stream().map(x->x*x).reduce(0,(x,y)-> x+y);
    }
}
