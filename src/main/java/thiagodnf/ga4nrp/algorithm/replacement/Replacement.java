package thiagodnf.ga4nrp.algorithm.replacement;

import thiagodnf.ga4nrp.encoding.Solution;

import java.util.List;

public abstract class Replacement {
    public abstract List<Solution> execute(List<Solution> population, List<Solution> offspring);
}
