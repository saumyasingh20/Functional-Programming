package Programming;

import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(2,3,5);
        int sum = addListFunctional(numbers);
        System.out.println(sum);
        int product = mulListFunctional(numbers);
        System.out.println(product);

    }

    private static int sum(int aggregate, int nextNumber){
        System.out.println(aggregate+" "+nextNumber);
        return aggregate+nextNumber;
    }
    private static int mul(int aggregate, int nextNumber){
        System.out.println(aggregate+" "+nextNumber);
        return aggregate*nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        return  numbers.stream()
                .reduce(0,Integer::sum);
                //.reduce(0,(a,b)-> a+b); //using lambda
                //.reduce(0,FP02Functional::sum );
                //0 is the initial value
    }

    private static int mulListFunctional(List<Integer> numbers) {
        return  numbers.stream()
                .reduce(1,(a,b)-> a*b);

               // .reduce(1,FP02Functional::mul );
        //1 is the initial value
    }
}
