package project_euler_solutions;


import project_euler_solutions.lib.LongestCollatzSequence;

public class Application {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Long result = LongestCollatzSequence.longestCollatzSequence(999_999);
        System.out.println(result);
        System.out.println("Took " + (System.currentTimeMillis() - time) + "MS");
    }
}
