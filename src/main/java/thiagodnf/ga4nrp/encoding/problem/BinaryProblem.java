package thiagodnf.ga4nrp.encoding.problem;

import thiagodnf.ga4nrp.encoding.Solution;
import thiagodnf.ga4nrp.util.RandomUtils;

public abstract class BinaryProblem extends Problem {

    protected int maxBits;

    public BinaryProblem(int maxBits) {
        this.maxBits = maxBits;
    }

    @Override
    public Solution createRandomSolution() {

        Solution solution = new Solution(maxBits);

        for (int i = 0; i < maxBits; i++) {
            solution.setVariable(i, RandomUtils.randInt(0, 1));
        }

        return solution;
    }
}
