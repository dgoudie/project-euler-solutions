package project_euler_solutions.lib;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargeSum {

    public static String largeSum(String block,
                                  int digits) {
        List<BigInteger> parsedNumbers = parseBlock(block);
        BigInteger sum = calculate(parsedNumbers);
        return sum.toString().substring(0, 10);
    }

    private static List<BigInteger> parseBlock(String block) {
        return Arrays
                .stream(block.split("[ \n]"))
                .map(BigInteger::new)
                .collect(Collectors.toList());
    }

    private static BigInteger calculate(List<BigInteger> parsedNumbers) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger parsedNumber : parsedNumbers) {
            sum = sum.add(parsedNumber);
        }
        return sum;
    }
}
