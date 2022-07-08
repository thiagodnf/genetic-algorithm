package thiagodnf.ga;

import lombok.Getter;
import lombok.Setter;
import thiagodnf.ga.operator.crossover.Crossover;
import thiagodnf.ga.operator.mutation.Mutation;
import thiagodnf.ga.operator.replacement.Replacement;
import thiagodnf.ga.operator.selection.Selection;
import thiagodnf.ga.encoding.problem.Problem;
import thiagodnf.ga.encoding.Solution;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GeneticAlgorithm {

    private Problem problem;

    private int populationSize;

    private int maxGenerations;

    private Selection selection;

    private Crossover crossover;

    private Mutation mutation;

    private Replacement replacement;

    public GeneticAlgorithm(Problem problem, int populationSize, int maxGenerations) {

        this.problem = problem;
        this.populationSize = populationSize;
        this.maxGenerations = maxGenerations;
    }

    public List<Solution> createRandomPopulation() {

        List<Solution> population = new ArrayList<>();

        for (int i = 0; i < populationSize; i++) {
            population.add(problem.createRandomSolution());
        }

        return population;
    }

    public void evaluate(List<Solution> solutions) {

        for (Solution solution : solutions) {
            solution.setFitness(problem.evaluate(solution));
        }
    }

    public Solution run() {

        List<Solution> population = createRandomPopulation();

        evaluate(population);

        for (int i = 0; i < maxGenerations; i++) {

            List<Solution> parents = selection.execute(population);

            List<Solution> offspring = crossover.execute(parents);

            mutation.execute(offspring);

            evaluate(offspring);

            population = replacement.execute(population, offspring);
        }

        return population.get(0);
    }


}
