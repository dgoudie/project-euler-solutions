package project_euler_solutions.lib;

import java.util.HashMap;
import java.util.Map;

public class LongestCollatzSequence {

    private static final Map<Long, Long> CACHE = new HashMap<>();

    static {
        CACHE.put(4L, 3L);
        CACHE.put(2L, 2L);
        CACHE.put(1L, 1L);
    }

    public static long longestCollatzSequence(long maxStartingNumber) {
        long longestSequenceStartingNumber = 0;
        long largestSequenceLength = 0;
        for (long i = 1; i <= maxStartingNumber; i++) {
            long result = getSequenceLength(i);
            if (result > largestSequenceLength) {
                largestSequenceLength = result;
                longestSequenceStartingNumber = i;
            }
        }
        return longestSequenceStartingNumber;
    }

    private static long getSequenceLength(long num) {
        long startingNum = num;
        int counter = 0;
        while (!CACHE.containsKey(num)) {
            counter += 1;
            boolean isEven = num % 2 == 0;
            if (isEven) {
                num /= 2;
            } else {
                num = (3 * num) + 1;
            }
        }
        long sequenceLength = counter + CACHE.get(num);
        CACHE.put(startingNum, sequenceLength);
        return sequenceLength;
    }
}
