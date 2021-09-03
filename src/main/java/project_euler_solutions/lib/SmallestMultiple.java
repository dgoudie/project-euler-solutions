package project_euler_solutions.lib;

public class SmallestMultiple {

    public static long smallestMultipleEvenlyDivisibleByNumbersInRange(long min, long max) {
        long counter = max;
        while(true) {
            boolean isDivisibleByAll = true;
            for (long i = min; i <= max; i++) {
                if (!isDivisibleBy(counter, i)) {
                    isDivisibleByAll = false;
                    break;
                }
            }
            if (isDivisibleByAll) {
                return counter;
            }
            counter += 1;
        }
    }

    private static boolean isDivisibleBy(long top, long bottom) {
        return top % bottom == 0;
    }
}
