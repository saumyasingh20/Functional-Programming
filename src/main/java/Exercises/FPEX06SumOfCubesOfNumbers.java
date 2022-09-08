package Exercises;

import java.util.List;

public class FPEX06SumOfCubesOfNumbers
{
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,3,5,0,9,89,4);
        int sum = sumOfCubesOfList(numbers);
        System.out.println("sum of cubes = " +sum);
    }

    private static int sumOfCubesOfList(List<Integer> numbers) {
        return numbers.stream().map(x->x*x*x).reduce(0,Integer::sum);
    }
}
