package Programming;

import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {

        List <Integer> numbers = List.of(12,98,98,9,87,23,56,45,65);
        int sum = addListStructured(numbers);
        System.out.println(sum);

    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for(int num:numbers){
            sum+=num;
        }
        return sum;
    }
}
