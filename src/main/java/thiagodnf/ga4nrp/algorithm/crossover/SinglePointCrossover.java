package thiagodnf.ga4nrp.algorithm.crossover;

import thiagodnf.ga4nrp.encoding.Solution;
import thiagodnf.ga4nrp.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class SinglePointCrossover extends Crossover {
    public SinglePointCrossover(double probability) {
        super(probability);
    }

    public List<Solution> execute(List<Solution> parents) {

        List<Solution> offspring = new ArrayList<>();

        for (int i = 0; i < parents.size() - 1; i += 2) {

            Solution s1 = parents.get(i).copy();
            Solution s2 = parents.get(i + 1).copy();

            offspring.addAll(doCrossover(s1, s2));
        }

        return offspring;
    }

    public List<Solution> doCrossover(Solution s1, Solution s2) {

        int pos = RandomUtils.randInt(0, s1.getNumberOfVariables() - 1);

        List<Solution> offspring = new ArrayList<>();

        offspring.add(s1);
        offspring.add(s2);

        if (RandomUtils.randDouble() <= probability) {

            int numberOfBits = s1.getNumberOfVariables();

            // Generate the children
            for (int i = 0; i < numberOfBits; i++) {

                if (i <= pos) {
                    offspring.get(0).setVariable(i, s1.getVariable(i));
                    offspring.get(1).setVariable(i, s2.getVariable(i));
                } else {
                    offspring.get(0).setVariable(i, s2.getVariable(i));
                    offspring.get(1).setVariable(i, s1.getVariable(i));
                }
            }
        }

        return offspring;
    }
}
