package general.store;

public class PickingTimeCalculator {
    UniformRandomStream random;

    public PickingTimeCalculator(double pickingMin, double pickingMax, int seed) {
        random = new UniformRandomStream(pickingMin, pickingMax, seed);
    }

    public double getTime() {
        return random.next();
    }
}
