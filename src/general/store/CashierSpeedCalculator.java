package general.store;

public class CashierSpeedCalculator {
    UniformRandomStream random;

    public CashierSpeedCalculator(double cashierMin, double cashierMax, int seed) {
        random = new UniformRandomStream(cashierMin, cashierMax, seed);
    }

    public double getTime() {
        return random.next();
    }
}
