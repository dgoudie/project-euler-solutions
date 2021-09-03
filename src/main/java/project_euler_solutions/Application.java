package project_euler_solutions;


import project_euler_solutions.lib.LatticePaths;
import project_euler_solutions.lib.LongestCollatzSequence;
import project_euler_solutions.lib.PowerDigitSum;

public class Application {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Long result = PowerDigitSum.powerDigitSum(2, 1000);
        System.out.println(result);
        System.out.println("Took " + (System.currentTimeMillis() - time) + "MS");
    }
}
