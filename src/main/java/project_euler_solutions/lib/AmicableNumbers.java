package project_euler_solutions.lib;

import java.util.ArrayList;
import java.util.List;

public class AmicableNumbers {
    public static long amicableNumbers(int max) {
        List<Integer> amicableNumbers = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            boolean result = isAmicable(i);
            if (result) {
                amicableNumbers.add(i);
            }
        }
        return amicableNumbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isAmicable(int i) {
        if (i == 1) {
            return false;
        }
        int sumOfFactors = sumOfFactors(i);
        int sumOfSumOfFactors = sumOfFactors(sumOfFactors);
        return i == sumOfSumOfFactors && sumOfFactors != sumOfSumOfFactors;
    }

    private static int sumOfFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
                int factor = num / i;
                if (factor != i && factor != num) {
                    factors.add(factor);
                }
            }
        }
        return factors
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
