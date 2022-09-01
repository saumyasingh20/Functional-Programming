package Programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printAllNumbersStructured(List.of(12,9898,9,87,23,56,45,65));
    }

    private static void printAllNumbersStructured(List<Integer> numbers) {
        //how to loop the numbers ?
        for(int num:numbers){
            System.out.println(num);
        }
    }
}
