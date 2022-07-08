package thiagodnf.ga.example;

import thiagodnf.ga.GeneticAlgorithm;
import thiagodnf.ga.encoding.Solution;
import thiagodnf.ga.encoding.problem.Problem;
import thiagodnf.ga.operator.crossover.SinglePointCrossover;
import thiagodnf.ga.operator.mutation.BitFlipMutation;
import thiagodnf.ga.operator.replacement.BestSolutionsReplacement;
import thiagodnf.ga.operator.selection.TournamentSelection;

public class MainClass {

    public static void main(String[] args) {

        int populationSize = 100;
        int maxGenerations = 1000;

        Problem problem = new ZeroOneProblem(10);

        GeneticAlgorithm ga = new GeneticAlgorithm(problem, populationSize, maxGenerations);

        ga.setSelection(new TournamentSelection(2));
        ga.setCrossover(new SinglePointCrossover(0.95));
        ga.setMutation(new BitFlipMutation(0.005));
        ga.setReplacement(new BestSolutionsReplacement());

        Solution bestSolution = ga.run();

        System.out.println(bestSolution);
    }
}
