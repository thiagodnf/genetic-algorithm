package thiagodnf.ga.encoding.problem;

import thiagodnf.ga.encoding.Solution;

public abstract class Problem {

    public abstract double evaluate(Solution sol);

    public abstract Solution createRandomSolution();
}
