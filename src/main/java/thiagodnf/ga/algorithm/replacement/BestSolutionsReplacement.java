package thiagodnf.ga.algorithm.replacement;

import thiagodnf.ga.encoding.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSolutionsReplacement extends Replacement {

    @Override
    public List<Solution> execute(List<Solution> population, List<Solution> offspring) {

        List<Solution> allSolutions = new ArrayList<>();

        allSolutions.addAll(population);
        allSolutions.addAll(offspring);

        Collections.sort(allSolutions);

        List<Solution> newPopulation = new ArrayList<>();

        for (int i = 0; i < population.size(); i++) {
            newPopulation.add(allSolutions.get(i));
        }

        return newPopulation;
    }
}
