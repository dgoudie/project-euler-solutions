package project_euler_solutions.lib;

public class HighestDivisibleTriangularNumber {

    public static long highestDivisibleTriangularNumber(int divisorCount) {
        int counter = 0;
        while(true) {
            counter += 1;
            int triangleNumber = triangleFor(counter);
            int divisorCountForTriangleNumber = getDivisorCountForTriangleNumber(triangleNumber);
            System.out.println("divisor_count=" + divisorCountForTriangleNumber);
            if (divisorCountForTriangleNumber > divisorCount) {
                return triangleNumber;
            }
        }
    }

    private static int triangleFor(int counter) {
        int sum = 0;
        for (int i = 0; i <= counter; i++) {
            sum += i;
        }
        System.out.print("Triangle for " + counter + "=" + sum + "...");
        return sum;
    }

    private static int getDivisorCountForTriangleNumber(int triangleNumber) {
        int counter = 0;
        for (int i = 1; i <= Math.sqrt(triangleNumber); i++) {
            if (triangleNumber % i == 0) {
                if (triangleNumber / i == i) {
                    counter += 1;
                } else {
                    counter += 2;
                }
            }
        }
        return counter;
    }
}
