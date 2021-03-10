package general.store;

public class CashierSpeedCalculator {
    UniformRandomStream random;

    public CashierSpeedCalculator(float min, float max, int seed) {
        random = new UniformRandomStream(min, max, seed);
    }

    public CashierSpeedCalculator(double cashierMin, double cashierMax, int randomizerSeed) {
    }

    public double getTime() {
        //return random.next();
        return 2.0;
    }
}
