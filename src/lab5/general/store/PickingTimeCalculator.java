package lab5.general.store;

/**
 * <p>
 * Picks a random time.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class PickingTimeCalculator {
    UniformRandomStream random;

    /**
     * Costructor for PickingTimeCalculator
     * @param pickingMin Minimum picking time.
     * @param pickingMax Maximum picking time.
     * @param seed Seed of the simulation.
     */
    public PickingTimeCalculator(double pickingMin, double pickingMax, long seed) {
        random = new UniformRandomStream(pickingMin, pickingMax, seed);
    }

   /**
     * @return Next time.
     */
    public double getTime() {
        return random.next();
    }
}
