package project_euler_solutions.lib;


import project_euler_solutions.utils.Utils;

public class HighestPrimeFactor {

    public static Long highestPrimeFactor(Long num) {
        long counter = 2L;

        while (counter < num / 2) {

            if (num % counter == 0) {
                Long result = num / counter;
                System.out.println(result + " is a factor");
                //is a factor
                if (Utils.isPrime(result)) {
                    return result;
                }
            }
            counter += 1;
        }
        return null;
    }
}
