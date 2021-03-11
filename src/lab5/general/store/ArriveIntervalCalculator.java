package lab5.general.store;

public class ArriveIntervalCalculator {
    ExponentialRandomStream random;

    /**
     * 
     * @param arriveInterval
     * @param seed
     */
    public ArriveIntervalCalculator(double arriveInterval, long seed) {
        random = new ExponentialRandomStream(arriveInterval, seed);
    }

    /**
     * 
     * @return
     */
    public double getTime() {
        return random.next();
    }
}
