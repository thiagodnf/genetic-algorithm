package thiagodnf.ga4nrp.algorithm.selection;

import thiagodnf.ga4nrp.encoding.Solution;

import java.util.List;

public abstract class Selection {

    public abstract List<Solution> execute(List<Solution> solutions);
}
