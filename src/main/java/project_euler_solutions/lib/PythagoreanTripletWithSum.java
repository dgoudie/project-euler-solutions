package project_euler_solutions.lib;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTripletWithSum {

    public static long pythagoreanTripletWithSum(int sum) {
        List<Triple<Integer, Integer, Integer>> triplets = getTripletsThatAddUpTo(sum);
        Triple<Integer, Integer, Integer> result = triplets.stream().filter(PythagoreanTripletWithSum::isPythagoreanTriplet).findFirst().orElse(null);
        if (result == null) {
            return -1;
        }
        return (long) result.getLeft() * result.getMiddle() * result.getRight();
    }

    private static List<Triple<Integer, Integer, Integer>> getTripletsThatAddUpTo(int sum) {
        List<Triple<Integer, Integer, Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            for (int i1 = i + 1; i1 < sum; i1++) {
                if (i + i1 > sum) {
                    continue;
                }
                for (int i2 = i1 + 1; i2 < sum; i2++) {
                    if (i + i1 + i2 == sum) {
                        triplets.add(
                                Triple.of(i, i1, i2)
                        );
                    }
                }
            }
        }
        return triplets;
    }

    private static boolean isPythagoreanTriplet(Triple<Integer, Integer, Integer> triplet) {
        return Math.pow(triplet.getLeft(), 2) + Math.pow(triplet.getMiddle(), 2) == Math.pow(triplet.getRight(), 2);
    }
}
