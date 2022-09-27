package Exercises;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FPEX12BehaviouralParameterization {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
		
		Function<Integer, Integer> mappingSquaresFunction = x -> x*x;
		
		List<Integer> squaredNumbers = mapAndCreateList(numbers, mappingSquaresFunction);
		List<Integer> cubedNumbers = mapAndCreateList(numbers, x -> x*x*x);
		List<Integer> doubledNumbers = mapAndCreateList(numbers, x -> x*2);
		
		System.out.println(doubledNumbers);
		
		
	}

	/**
	 * @param numbers
	 * @param mappingFunction
	 * @return
	 */
	private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
		
		return numbers.stream()
					   .map(mappingFunction)
					  .collect(Collectors.toList());
	}
	
	

}
