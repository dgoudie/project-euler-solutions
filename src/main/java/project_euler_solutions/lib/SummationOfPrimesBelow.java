package project_euler_solutions.lib;


import project_euler_solutions.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SummationOfPrimesBelow {

    public static long summationOfPrimesBelow(long num) {
        List<Long> primesBelowNum = new ArrayList<>();
        for (long i = 0; i < num; i++) {
            System.out.print(i + "...");
            boolean result = Utils.isPrime(i);
            if (result) {
                System.out.println("is prime");
                primesBelowNum.add(i);
            } else {
                System.out.println("is not prime");
            }
        }
        long sum = 0;
        for (Long aLong : primesBelowNum) {
            sum += aLong;
        }
        return sum;
    }


}
