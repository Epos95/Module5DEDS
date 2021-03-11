package lab5.general.store;

public class PickingTimeCalculator {
    UniformRandomStream random;

    /**
     * 
     * @param pickingMin
     * @param pickingMax
     * @param seed
     */
    public PickingTimeCalculator(double pickingMin, double pickingMax, long seed) {
        random = new UniformRandomStream(pickingMin, pickingMax, seed);
    }

    /**
     * 
     * @return
     */
    public double getTime() {
        return random.next();
    }
}
