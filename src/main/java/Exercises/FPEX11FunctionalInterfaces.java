package Exercises;

import java.util.List;
import java.util.function.BinaryOperator;

public class FPEX11FunctionalInterfaces {

	public static void main(String[] args) {
		 List<Integer> numbers = List.of(2,3,5,0,9,89,4);
	        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
	        
	        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {

				@Override
				public Integer apply(Integer n1, Integer n2) {
					// TODO Auto-generated method stub
					return n1+n2;
				}
	        	
	        	
	        };
			int sum = numbers.stream()
	                .reduce(0, sumBinaryOperator2);
	        System.out.println(sum);
	}

}
