package project_euler_solutions.lib;

public class SumSquareDifference {

    public static long sumSquareDifference(long max) {
        return squareOfSums(max) - sumOfSquares(max);
    }

    private static long sumOfSquares(long max) {
        long counter = 0;
        for (long i = 1; i <= max; i++) {
                counter += Math.pow(i, 2);
        }
        return counter;
    }

    private static long squareOfSums(long max) {
        long counter = 0;
        for (long i = 1; i <= max; i++) {
            counter += i;
        }
        return (long) Math.pow(counter, 2);
    }
}
