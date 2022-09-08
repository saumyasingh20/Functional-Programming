package Programming;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class FPO5CollectingStreamAsList {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,12,11,9,98,98,9,87,23,56,45,65);
        
        List<Integer> doubledNumbers = doubleList(numbers);
        System.out.println(numbers);
        System.out.println(doubledNumbers);
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> num*num)
                .collect(Collectors.toList());
    }

}
