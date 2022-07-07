package thiagodnf.ga4nrp.algorithm;

import thiagodnf.ga4nrp.algorithm.crossover.Crossover;
import thiagodnf.ga4nrp.algorithm.mutation.Mutation;
import thiagodnf.ga4nrp.algorithm.replacement.Replacement;
import thiagodnf.ga4nrp.algorithm.selection.Selection;
import thiagodnf.ga4nrp.encoding.problem.Problem;
import thiagodnf.ga4nrp.encoding.Solution;

import java.util.ArrayList;
import java.util.List;

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

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public void setReplacement(Replacement replacement){
        this.replacement = replacement;
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
