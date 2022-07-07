package thiagodnf.ga4nrp.encoding.problem;

import thiagodnf.ga4nrp.encoding.Solution;

public abstract class Problem {

    public abstract double evaluate(Solution sol);

    public abstract Solution createRandomSolution();
}
