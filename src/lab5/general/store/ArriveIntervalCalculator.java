package lab5.general.store;

/**
 * <p>
 * Calculates at what time a customer arrives.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class ArriveIntervalCalculator {
    ExponentialRandomStream random;


    /**
     * 
     * @param arriveInterval Interval from where time of arrival is calculated.
     * @param seed The seed of the simulation.
     */
    public ArriveIntervalCalculator(double arriveInterval, long seed) {
        random = new ExponentialRandomStream(arriveInterval, seed);
    }

    /**
     * @return A time.
     */
    public double getTime() {
        return random.next();
    }
}
