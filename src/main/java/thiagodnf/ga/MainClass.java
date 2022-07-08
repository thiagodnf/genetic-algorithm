package thiagodnf.ga;

import thiagodnf.ga.algorithm.GeneticAlgorithm;
import thiagodnf.ga.algorithm.crossover.SinglePointCrossover;
import thiagodnf.ga.algorithm.mutation.BitFlipMutation;
import thiagodnf.ga.algorithm.replacement.BestSolutionsReplacement;
import thiagodnf.ga.algorithm.selection.TournamentSelection;
import thiagodnf.ga.problem.ZeroOneProblem;
import thiagodnf.ga.encoding.Solution;

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
