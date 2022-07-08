package thiagodnf.ga4nrp;

import thiagodnf.ga4nrp.algorithm.GeneticAlgorithm;
import thiagodnf.ga4nrp.algorithm.crossover.SinglePointCrossover;
import thiagodnf.ga4nrp.algorithm.mutation.BitFlipMutation;
import thiagodnf.ga4nrp.algorithm.replacement.BestSolutionsReplacement;
import thiagodnf.ga4nrp.algorithm.selection.TournamentSelection;
import thiagodnf.ga4nrp.problem.ZeroOneProblem;
import thiagodnf.ga4nrp.encoding.Solution;

public class MainClass {
    public static void main(String[] args) {

        int maxBits = 100;
        int populationSize = 10;
        int maxGenerations = 1000;

        ZeroOneProblem problem = new ZeroOneProblem(maxBits);

        GeneticAlgorithm ga = new GeneticAlgorithm(problem, populationSize, maxGenerations);

        ga.setSelection(new TournamentSelection(2));
        ga.setCrossover(new SinglePointCrossover(0.95));
        ga.setMutation(new BitFlipMutation(0.005));
        ga.setReplacement(new BestSolutionsReplacement());

        Solution bestSolution = ga.run();

        System.out.println(bestSolution);
    }
}
