package general.store;

public class PickingTimeCalculator {
    UniformRandomStream random;

    public PickingTimeCalculator(double pickingMin, double pickingMax, long seed) {
        random = new UniformRandomStream(pickingMin, pickingMax, seed);
    }

    public double getTime() {
        return random.next();
    }
}
