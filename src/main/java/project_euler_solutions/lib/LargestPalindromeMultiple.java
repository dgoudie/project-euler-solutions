package project_euler_solutions.lib;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LargestPalindromeMultiple {

    public static Long largestPalindromeFromTwoNumbersUnder(long max) {

        Set<Long> palindromes = new HashSet<>();

        for (long i = max; i > 0; i--) {
            for(long j = max; j > 0; j--) {
                long result = i * j;
                if (isPalindrome(result)) {
                    palindromes.add(result);
                }
            }
        }
        return palindromes.stream().max(Comparator.comparing(aLong -> aLong)).orElse(null);
    }

    private static boolean isPalindrome(long num) {
        String numAsString = Long.toString(num);

        String reverse = new StringBuilder(numAsString).reverse().toString();
        return reverse.equals(numAsString);
    }
}
