package project_euler_solutions.lib;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LatticePaths {

    public static long latticePaths(int gridSize) {
        gridSize += 1;
        List<List<Long>> pascalsTriangle = buildPascalsTriangle(gridSize);
        pascalsTriangle = pascalsTriangle
                .stream()
                .filter(list -> list.size() % 2 == 1)
                .collect(Collectors.toList());
        return pascalsTriangle
                .get(pascalsTriangle.size() - 1)
                .stream()
                .max(Comparator.comparing(integer -> integer))
                .orElse(null);
    }

    private static List<List<Long>> buildPascalsTriangle(int gridSize) {
        List<List<Long>> rows = new ArrayList<>();
        for (int i = 0; i < gridSize * 2; i++) {
            if (i == 0) {
                rows.add(new ArrayList<>(Collections.singletonList(1L)));
            } else {
                List<Long> previousRow = rows.get(i - 1);
                List<Long> thisRow = new ArrayList<>();
                for (int i1 = 0; i1 < i + 1; i1++) {
                    if (i1 == 0) {
                        thisRow.add(previousRow.get(0));
                    } else if (i1 == i) {
                        thisRow.add(previousRow.get(i - 1));
                    } else {
                        thisRow.add(previousRow.get(i1) + previousRow.get(i1 - 1));
                    }
                }
                rows.add(thisRow);
            }
        }
        return rows;
    }
}
