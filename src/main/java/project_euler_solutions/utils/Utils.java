package project_euler_solutions.utils;

public class Utils {
    public static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }
        long counter = 1L;
        while (counter < Math.sqrt(num)) {
            counter += 2;
            if (num % counter == 0) {
                return false;
            }
        }
        return true;
    }
}
