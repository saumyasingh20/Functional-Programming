package Programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP06FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
		
		Predicate<Integer> evenPredicate = x -> x%2==0;
		
		Function<Integer, Integer> squareFunction = x -> x*x;
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		numbers.stream()
			.filter(evenPredicate)
			.map(squareFunction)
			.forEach(sysoutConsumer);
	}

}
