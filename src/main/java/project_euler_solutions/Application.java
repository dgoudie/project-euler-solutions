package project_euler_solutions;


import project_euler_solutions.lib.AmicableNumbers;
import project_euler_solutions.lib.MaximumPathSum;

public class Application {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Long result = AmicableNumbers.amicableNumbers(10_000);
        System.out.println(result);
        System.out.println("Took " + (System.currentTimeMillis() - time) + "MS");
    }
}
