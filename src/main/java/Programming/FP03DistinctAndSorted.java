package Programming;

import java.util.List;

public class FP03DistinctAndSorted {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
        //getDistinctIntegers(numbers);
        //sortIntegers(numbers);
        getDistinctSortedIntegers(numbers);

    }

    private static void getDistinctSortedIntegers(List<Integer> numbers) {
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    private static void sortIntegers(List<Integer> numbers) {
        numbers.stream().sorted().forEach(System.out::println);
    }

    private static void getDistinctIntegers(List<Integer> numbers) {
        numbers.stream().distinct().forEach(System.out::println);
    }
}
