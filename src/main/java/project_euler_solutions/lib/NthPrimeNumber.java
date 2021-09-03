package project_euler_solutions.lib;


import project_euler_solutions.utils.Utils;

public class NthPrimeNumber {

    public static long nthPrimeNumber(long n) {
        int counter = 1;
        int primeCounter = 0;
        while (true) {
            System.out.print(counter + "...isPrime:");
            boolean isPrime = Utils.isPrime(counter);
            System.out.print(isPrime);
            if (isPrime) {
                primeCounter += 1;
                System.out.println(" prime number " + primeCounter);
            } else {
                System.out.println();
            }
            if (primeCounter == n) {
                System.out.println(n + " prime number found");
                return counter;
            }
            counter += 1;
        }
    }
}
