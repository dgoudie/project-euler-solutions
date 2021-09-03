package project_euler_solutions.lib;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LargestProductInAGrid {

    public static long largestProductInAGrid(String gridToParse,
                                             int dimensions,
                                             int sequenceLength) {
        List<List<Integer>> grid = parseGrid(
                gridToParse,
                dimensions
        );

        return processGrid(
                grid,
                dimensions,
                sequenceLength
        );
    }

    private static List<List<Integer>> parseGrid(String gridToParse,
                                                 int dimensions) {
        List<Integer> parsedIntsOneDimension = Arrays
                .stream(gridToParse.split("[ \n]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        return Lists.partition(
                parsedIntsOneDimension,
                dimensions
        );
    }

    private static long processGrid(List<List<Integer>> grid,
                                    int dimensions,
                                    int sequenceLength) {
        long largestSequenceSum = 0;
        for (int x = 0; x < dimensions; x++) {
            for (int y = 0; y < dimensions; y++) {
                Long result = processXY(
                        grid,
                        x,
                        y,
                        dimensions,
                        sequenceLength
                );
                if (result == null) {
                    continue;
                }
                if (result > largestSequenceSum) {
                    largestSequenceSum = result;
                }
            }
        }
        return largestSequenceSum;
    }

    private static Long processXY(List<List<Integer>> grid,
                                  int x,
                                  int y,
                                  int dimensions,
                                  int sequenceLength) {
        List<Long> products = new ArrayList<>();
        System.out.print("Processing XY: " + x + "|" + y + "...");
        products.add(processRight(
                grid,
                x,
                y,
                dimensions,
                sequenceLength
        ));
        products.add(processDown(
                grid,
                x,
                y,
                dimensions,
                sequenceLength
        ));
        products.add(processDownRight(
                grid,
                x,
                y,
                dimensions,
                sequenceLength
        ));
        products.add(processDownLeft(
                grid,
                x,
                y,
                dimensions,
                sequenceLength
        ));
        System.out.println("right=" + products.get(0) + ",down=" + products.get(1) + ",down_right=" + products.get(2) + ",down_left=" + products.get(3));
        products = products
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (products.isEmpty()) {
            return null;
        }
        return products
                .stream()
                .max(Comparator.comparing(aLong -> aLong))
                .orElse(null);
    }

    private static Long processRight(List<List<Integer>> grid,
                                     int x,
                                     int y,
                                     int dimensions,
                                     int sequenceLength) {
        if (y > dimensions - sequenceLength) {
            return null;
        }
        List<Integer> row = grid.get(x);
        List<Integer> sequence = row.subList(
                y,
                sequenceLength + y
        );
        long product = sequence.get(0);
        for (int i = 1; i < sequence.size(); i++) {
            product *= sequence.get(i);
        }
        return product;
    }

    private static Long processDown(List<List<Integer>> grid,
                                    int x,
                                    int y,
                                    int dimensions,
                                    int sequenceLength) {
        if (x > dimensions - sequenceLength) {
            return null;
        }
        List<List<Integer>> rowsNeeded = grid.subList(
                x,
                sequenceLength + x
        );
        long product = rowsNeeded
                .get(0)
                .get(y);
        for (int i = 1; i < rowsNeeded.size(); i++) {
            product *= rowsNeeded
                    .get(i)
                    .get(y);
        }
        return product;
    }

    private static Long processDownRight(List<List<Integer>> grid,
                                         int x,
                                         int y,
                                         int dimensions,
                                         int sequenceLength) {
        if (x > dimensions - sequenceLength) {
            return null;
        }
        if (y > dimensions - sequenceLength) {
            return null;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < sequenceLength; i++) {
            numbers.add(
                    grid
                            .get(x + i)
                            .get(y + i)
            );
        }
        long product = numbers
                .get(0);
        for (int i = 1; i < numbers.size(); i++) {
            product *= numbers
                    .get(i);
        }
        return product;
    }

    private static Long processDownLeft(List<List<Integer>> grid,
                                         int x,
                                         int y,
                                         int dimensions,
                                         int sequenceLength) {
        if (x < sequenceLength - 1) {
            return null;
        }
        if (y > dimensions - sequenceLength) {
            return null;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < sequenceLength; i++) {
            numbers.add(
                    grid
                            .get(x - i)
                            .get(y + i)
            );
        }
        long product = numbers
                .get(0);
        for (int i = 1; i < numbers.size(); i++) {
            product *= numbers
                    .get(i);
        }
        return product;
    }
}
