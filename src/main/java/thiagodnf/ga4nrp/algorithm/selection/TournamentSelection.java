package thiagodnf.ga4nrp.algorithm.selection;

import thiagodnf.ga4nrp.encoding.Solution;
import thiagodnf.ga4nrp.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class TournamentSelection extends Selection {

    public double tournaments;

    public TournamentSelection(int tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public List<Solution> execute(List<Solution> solutions) {

        List<Solution> selected = new ArrayList<>();

        for (int i = 0; i < solutions.size(); i++) {

            selected.add(doSelection(solutions));
        }

        return selected;
    }

    public Solution doSelection(List<Solution> solutions) {

        Solution selected = RandomUtils.randElement(solutions);

        for (int i = 0; i < tournaments - 1; i++) {

            Solution current = RandomUtils.randElement(solutions);

            if (current.getFitness() < selected.getFitness()) {
                selected = current;
            }
        }

        return selected;
    }
}
