package Programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP06FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
		
		/* ( Predicate - it is used with streams with the filter method , 
		 usually returns true and false)*/
		Predicate<Integer> evenPredicate = x -> x%2==0;
		
		Predicate<Integer> evenPredicate2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				
				return x%2==0;
			}};
		
		
		/* (Function - it is used with the streams with the map method, 
		 * it performs some function on the input and 
		 * returns an output 
		 * for example, after passing (x) => we might 
		 * return x*x or x+9 or x*3 )*/
		Function<Integer, Integer> squareFunction = x -> x*x;
		
		Function<Integer, Integer> squareFunction2 = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer x) {
				
				return x*x;
			}};
		
		
		
		/* ( Consumer it consumes the input that is might print it on to the console,
		 *  send it to utility or save it to the database , 
		 *  i.e it just consumes it and does not return anything back) */
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer x) {
				System.out.println(x);
				
			}};
		
		numbers.stream()
			.filter(evenPredicate)
			.map(squareFunction)
			.forEach(sysoutConsumer);
		
		
		//Supplier - No Input -> return something
		
		Supplier<Integer> randomIntegerSupplier = () -> {
													Random r = new Random()	;
													return r.nextInt(5000);
												};
		
		//System.out.println(randomIntegerSupplier.get());
		
		/* Unary Operator - takes one parameter as i/p and
		 returns same type of output */
		
		UnaryOperator<Integer> tripleNumber = (x) -> 3*x;
		
		System.out.println(tripleNumber.apply(10));
		
		//BiPredicate - takes two arguments as i/p and returns a boolean
		
		BiPredicate<Integer,String> biPredicate = (num,str) -> { 
			
			return num<10 && str.length()>5 ;
		} ;
		System.out.println(biPredicate.test(5,"saum"));
		
	/*BiFunction - takes two arguments as i/p of first two types 
	and returns an o/p of third type */
		
		BiFunction<Integer,String, String> biFunction = (num,str) -> { 
			
			return num+" "+str ;
		} ;
		
		System.out.println(biFunction.apply(5,"saum"));
		
		
		BiConsumer<String, String> biConsumer = (str1,str2) ->
		{
			System.out.println(str1+" " + str2);
		};
		
		biConsumer.accept("saumya", "singh");
		
		
	}

}
