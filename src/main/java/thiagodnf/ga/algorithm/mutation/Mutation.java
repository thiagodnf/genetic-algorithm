package thiagodnf.ga.algorithm.mutation;

import thiagodnf.ga.encoding.Solution;

import java.util.List;

public abstract class Mutation {

    protected double probability;

    public Mutation(double probability) {
        this.probability = probability;
    }

    public abstract void execute(List<Solution> offspring);
}
