package general.store;

import java.util.Objects;

public class ArriveIntervalCalculator {
    ExponentialRandomStream random;

    public ArriveIntervalCalculator(float arriveInterval, long seed) {
        if (Objects.isNull(seed)) {

        }
        random = new ExponentialRandomStream(arriveInterval, seed);
    }

    public ArriveIntervalCalculator(double arriveInterval, int randomizerSeed) {
    }

    public double getTime() {
        return random.next();
    }
}
