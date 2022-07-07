package thiagodnf.ga4nrp.encoding;

import thiagodnf.ga4nrp.util.SolutionUtils;

import java.util.Arrays;

public class Solution implements Comparable<Solution> {

    /**
     * The thiagodnf.ga4nrp.solution Id
     */
    protected long id;

    /**
     * The list of variables
     */
    protected Object[] variables;

    /**
     * The fitness value for a given thiagodnf.ga4nrp.solution
     */
    protected double fitness = 0.0;

    public Solution(int numberOfVariables) {
        this.id = SolutionUtils.SOLUTION_COUNTER++;
        this.variables = new Object[numberOfVariables];
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getNumberOfVariables() {
        return this.variables.length;
    }

    public Object getVariable(int index) {
        return this.variables[index];
    }

    public void setVariable(int index, Object value) {
        this.variables[index] = value;
    }

    public Solution copy() {

        Solution copy = new Solution(this.getNumberOfVariables());

        copy.fitness = this.fitness;

        for (int i = 0; i < getNumberOfVariables(); i++) {
            copy.variables[i] = this.variables[i];
        }

        return copy;
    }

    @Override
    public String toString() {

        return "#" + id + " " + Arrays.toString(this.variables) + " = " + fitness;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public int compareTo(Solution solution) {
        return Double.compare(this.fitness, solution.fitness);
    }
}
