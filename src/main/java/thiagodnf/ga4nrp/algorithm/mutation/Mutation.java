package thiagodnf.ga4nrp.algorithm.mutation;

import thiagodnf.ga4nrp.encoding.Solution;

import java.util.List;

public abstract class Mutation {

    protected double probability;

    public Mutation(double probability) {
        this.probability = probability;
    }

    public abstract void execute(List<Solution> offspring);
}
