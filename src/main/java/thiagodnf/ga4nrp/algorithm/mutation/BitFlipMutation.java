package thiagodnf.ga4nrp.algorithm.mutation;

import thiagodnf.ga4nrp.encoding.Solution;
import thiagodnf.ga4nrp.util.RandomUtils;

import java.util.List;

public class BitFlipMutation extends Mutation {

    public BitFlipMutation(double probability) {
        super(probability);
    }

    @Override
    public void execute(List<Solution> offspring) {

        for (Solution solution : offspring) {
            doMutation(solution);
        }
    }

    protected void doMutation(Solution solution) {

        for (int i = 0; i < solution.getNumberOfVariables(); i++) {

            if (RandomUtils.randDouble() <= probability) {

                if ((int) solution.getVariable(i) == 0) {
                    solution.setVariable(i, 1);
                } else {
                    solution.setVariable(i, 0);
                }
            }
        }
    }
}
