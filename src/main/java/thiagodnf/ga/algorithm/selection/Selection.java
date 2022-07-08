package thiagodnf.ga.algorithm.selection;

import thiagodnf.ga.encoding.Solution;

import java.util.List;

public abstract class Selection {

    public abstract List<Solution> execute(List<Solution> solutions);
}
