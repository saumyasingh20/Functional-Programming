package Programming;

import java.util.List;
import java.util.function.Predicate;

public class FP07BehaviourParameterization {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
		
		Predicate<Integer> evenPredicate = x -> x%2 == 0;
		
		filterAndPrint(numbers, evenPredicate);
		
		
		Predicate<Integer> oddPredicate = x -> x%2!=0;
		
		filterAndPrint(numbers, oddPredicate);
		
		filterAndPrint(numbers, x -> x%3==0);
	}

	/**
	 * @param numbers
	 * @param evenPredicate
	 */
	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
			.filter(predicate)
			.forEach(System.out::println);
	}

}
