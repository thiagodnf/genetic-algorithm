package thiagodnf.ga.util;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static Random random;

    static {
        random = new Random();
    }

    public static double randDouble(){
        return random.nextDouble();
    }

    public static int randInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static <E> E randElement(List<E> solutions) {

        int randomIndex = RandomUtils.randInt(0, solutions.size() - 1);

        return solutions.get(randomIndex);
    }
}
