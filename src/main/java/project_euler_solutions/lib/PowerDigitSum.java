package project_euler_solutions.lib;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PowerDigitSum {
    public static long powerDigitSum(int num, int exp) {
        BigInteger bigInteger = new BigInteger(String.valueOf(num));
        BigInteger powerOf = bigInteger.pow(exp);
        String numAsString = powerOf.toString();
        List<Integer> digits = Arrays.stream(numAsString.split("")).map(Integer::parseInt).collect(Collectors.toList());

        return digits.stream().reduce(0,
                Integer::sum
        );
    }
}
