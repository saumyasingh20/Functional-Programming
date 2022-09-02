package Programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

        //printAllNumbersFunctional(List.of(12,98,98,9,87,23,56,45,65));
        //printEvenNumbersFunctional(List.of(12,98,98,9,87,23,56,45,65));
        printSquaresOfEvenNumbersFunctional(List.of(12,98,98,9,87,23,56,45,65));
      //  printCubesOfOddNumbersFunctional(List.of(12,98,98,9,87,23,56,45,65));
    }

    private static void printSquaresOfEvenNumbersFunctional(List<Integer> integers) {
        integers.stream()
                .filter(num -> num%2==0)
                .map(num -> num + " " + num*num)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersFunctional(List<Integer> integers) {
        integers.stream()
                .filter(num -> num%2==1)
                .map(num -> num + " " + num*num*num)
                .forEach(System.out::println);
    }

    private static boolean isEven(int num){
        if(num%2==0)
            return true;

        return false;
    }
    private static void printEvenNumbersFunctional(List<Integer> integers) {
//   1.   using method reference within filter method
        //        integers.stream()
//                .filter(FP01Functional::isEven)
//                .forEach(System.out::println);

        // 2. optimisation using lambda expressions
        integers.stream()
                .filter(num -> num%2==0)
                .forEach(System.out::println);
    }

    private static void printAllNumbersFunctional(List<Integer> numbers) {
         //what to do ?
        numbers.stream().forEach(System.out::println);

        //method reference
    }


}
