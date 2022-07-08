package thiagodnf.ga.util;

import thiagodnf.ga.encoding.Solution;

import java.util.List;

public class SolutionUtils {

    public static long SOLUTION_COUNTER = 1;

    public static void print(List<Solution> solutions) {

        for (Solution solution : solutions) {
            System.out.println(solution);
        }
    }
}
