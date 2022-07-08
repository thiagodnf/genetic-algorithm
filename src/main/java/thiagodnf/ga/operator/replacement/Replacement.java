package thiagodnf.ga.operator.replacement;

import thiagodnf.ga.encoding.Solution;

import java.util.List;

public abstract class Replacement {
    public abstract List<Solution> execute(List<Solution> population, List<Solution> offspring);
}
