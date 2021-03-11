package lab5.general.store;

/**
 * <p>
 * Calcualtes the speed of checkouts.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */

public class CashierSpeedCalculator {
    UniformRandomStream random;

    /**
     * 
     * @param cashierMin Minium checkout time.
     * @param cashierMax Max checkout time.
     * @param seed Seed of the simulation.
     */
    public CashierSpeedCalculator(double cashierMin, double cashierMax, long seed) {
        random = new UniformRandomStream(cashierMin, cashierMax, seed);
    }

    /**
     * 
     * @return A time.
     */
    public double getTime() {
        return random.next();
    }
}
