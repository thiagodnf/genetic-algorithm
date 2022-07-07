package thiagodnf.ga4nrp.algorithm.crossover;

import thiagodnf.ga4nrp.encoding.Solution;

import java.util.List;

public abstract class Crossover {

    protected double probability;

    public Crossover(double probability) {
        this.probability = probability;
    }

    public abstract List<Solution> execute(List<Solution> parents);
}
