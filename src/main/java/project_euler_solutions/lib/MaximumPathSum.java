package project_euler_solutions.lib;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaximumPathSum {

    public static long maximumPathSum(String treeString) {
        List<List<Integer>> tree = parseTree(treeString);


        Map<Pair<Integer, Integer>, Integer> largestPathToYXCache = new HashMap<>();
        largestPathToYXCache.put(
                Pair.of(
                        0,
                        0
                ),
                tree
                        .get(0)
                        .get(0)
        );

        for (int rowIndex = 1; rowIndex < tree.size(); rowIndex++) {
            processRow(
                    tree.get(rowIndex),
                    rowIndex,
                    largestPathToYXCache
            );
        }
        int lastRowIndex = tree.size() - 1;
        List<Integer> maxPathsToEachBottomChild = new ArrayList<>();
        for (int columnIndex = 0; columnIndex < lastRowIndex; columnIndex++) {
            maxPathsToEachBottomChild.add(
                largestPathToYXCache.get(Pair.of(lastRowIndex, columnIndex))
            );
        }
        return maxPathsToEachBottomChild.stream().max(Integer::compareTo).orElse(null);
    }

    private static void processRow(List<Integer> row,
                                   int rowIndex,
                                   Map<Pair<Integer, Integer>, Integer> largestPathToYXCache) {
        processFirstColumn(
                row.get(0),
                rowIndex,
                largestPathToYXCache
        );
        for (int columnIndex = 1; columnIndex < row.size() - 1; columnIndex++) {
            processMiddleColumn(
                    columnIndex,
                    row,
                    rowIndex,
                    largestPathToYXCache
            );
        }
        processLastColumn(
                row.get(rowIndex),
                rowIndex,
                largestPathToYXCache
        );
    }

    private static void processFirstColumn(Integer firstColumnValue,
                                           int rowIndex,
                                           Map<Pair<Integer, Integer>, Integer> largestPathToYXCache) {
        Integer previousRowFirstColumnValue = largestPathToYXCache.get(Pair.of(
                rowIndex - 1,
                0
        ));
        largestPathToYXCache.put(
                Pair.of(
                        rowIndex,
                        0
                ),
                previousRowFirstColumnValue + firstColumnValue
        );
    }

    private static void processMiddleColumn(int columnIndex,
                                            List<Integer> row,
                                            int rowIndex,
                                            Map<Pair<Integer, Integer>, Integer> largestPathToYXCache) {
        int parentRowIndex = rowIndex - 1;
        Pair<Integer, Integer> firstParentLocation = Pair.of(
                parentRowIndex,
                columnIndex - 1
        );
        Pair<Integer, Integer> secondParentLocation = Pair.of(
                parentRowIndex,
                columnIndex
        );
        Integer largestPathToFirstParent = largestPathToYXCache.get(firstParentLocation);
        Integer largestPathToSecondParent = largestPathToYXCache.get(secondParentLocation);
        if (largestPathToFirstParent > largestPathToSecondParent) {
            largestPathToYXCache.put(
                    Pair.of(
                            rowIndex,
                            columnIndex
                    ),
                    largestPathToFirstParent + row.get(columnIndex)
            );
        } else {
            largestPathToYXCache.put(
                    Pair.of(
                            rowIndex,
                            columnIndex
                    ),
                    largestPathToSecondParent + row.get(columnIndex)
            );
        }
    }

    private static void processLastColumn(Integer lastColumnValue,
                                          int rowIndex,
                                          Map<Pair<Integer, Integer>, Integer> largestPathToYXCache) {
        Integer previousRowLastColumnValue = largestPathToYXCache.get(Pair.of(
                rowIndex - 1,
                rowIndex - 1
        ));
        largestPathToYXCache.put(
                Pair.of(
                        rowIndex,
                        rowIndex
                ),
                previousRowLastColumnValue + lastColumnValue
        );
    }

    private static List<List<Integer>> parseTree(String treeString) {
        List<String> rowStrings = List.of(treeString.split("\n"));
        return rowStrings
                .stream()
                .map(rowString -> Arrays
                        .stream(rowString.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
