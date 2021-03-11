package general.store;

public class ArriveIntervalCalculator {
    ExponentialRandomStream random;

    public ArriveIntervalCalculator(double arriveInterval, long seed) {
        random = new ExponentialRandomStream(arriveInterval, seed);
    }

    public double getTime() {
        return random.next();
    }
}
