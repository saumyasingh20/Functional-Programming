package Exercises;

import java.util.List;

public class MaxMinWithLambdaAndReduce {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2,3,5,0,9,89,4);
        int max = findMaxInListFunctional(numbers);
        System.out.println("max = " +max);
        int min = findMinInListFunctional(numbers);
        System.out.println("min = "+ min);

    }

    private static int findMinInListFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y? x:y);
    }

    private static int findMaxInListFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MIN_VALUE,(x,y)->x>y? x:y);
    }
}
