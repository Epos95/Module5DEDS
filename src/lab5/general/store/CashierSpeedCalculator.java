package lab5.general.store;

public class CashierSpeedCalculator {
    UniformRandomStream random;

    /**
     * 
     * @param cashierMin
     * @param cashierMax
     * @param seed
     */
    public CashierSpeedCalculator(double cashierMin, double cashierMax, long seed) {
        random = new UniformRandomStream(cashierMin, cashierMax, seed);
    }

    /**
     * 
     * @return
     */
    public double getTime() {
        return random.next();
    }
}
