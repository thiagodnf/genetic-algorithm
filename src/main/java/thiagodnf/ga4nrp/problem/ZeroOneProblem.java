package thiagodnf.ga4nrp.problem;

import thiagodnf.ga4nrp.encoding.Solution;
import thiagodnf.ga4nrp.encoding.problem.BinaryProblem;

public class ZeroOneProblem extends BinaryProblem {

    public ZeroOneProblem(int maxBits) {
        super(maxBits);
    }

    public double evaluate(Solution solution) {

        int total = 0;

        for (int i = 0; i < solution.getNumberOfVariables(); i++) {

            if ((int) solution.getVariable(i) == 1) {
                total++;
            }
        }

        return -1.0 * total;
    }
}
