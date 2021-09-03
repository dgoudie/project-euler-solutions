package project_euler_solutions.lib;

import java.util.List;
import java.util.stream.Collectors;

public class LargestProductInASeries {

    public static long largestProductInASeries(String s, int digits) {
        long largest = 0;
        for (int i = 0; i < s.length() - digits; i++) {
            String sub = s.substring(i, i + digits);
            List<Integer> numbers = splitStringIntoNumbers(sub);
            long product = numbers.get(0);
            numbers.remove(0);
            for (Integer number : numbers) {
                product = product * number;
            }
            if (product > largest) {
                largest = product;
            }
        }
        return largest;
    }

    private static List<Integer> splitStringIntoNumbers(String s) {
        List<String> strings = List.of(s.split(""));
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
