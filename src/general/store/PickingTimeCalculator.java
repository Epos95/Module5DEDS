package general.store;

public class PickingTimeCalculator {
    UniformRandomStream random;

    public PickingTimeCalculator(float min, float max, int seed) {
        random = new UniformRandomStream(min, max, seed);
    }

    public PickingTimeCalculator(double pickingMin, double pickingMax, int randomizerSeed) {
    }

    public double getTime() {
        return random.next();
    }
}
