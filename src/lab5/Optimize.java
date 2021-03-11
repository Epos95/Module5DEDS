package lab5;

import java.util.Random;

import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.store.StoreState;
import lab5.general.store.events.StartEvent;

/**
 * Tries to optimize the parameters of the store, open checkouts etc.
 * 
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class Optimize {

	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {

		// --
		System.out.println("Söker efter det optimala antalet kassor!");
		
		// Execute optimize
		int resultat = optimizeCashierAmount(
				K.M, 		
				K.L, 	
				K.LOW_PAYMENT_TIME, 
				K.HIGH_PAYMENT_TIME, 
				K.LOW_COLLECTION_TIME,
				K.HIGH_COLLECTION_TIME,
				K.END_TIME,
				K.SEED
		);
		
		// --
		System.out.println(String.format("Det optimala antalet kassor är %s.", resultat));
	}
	
	/**
	 * METOD 1
	 * @param cashRegisters
	 * @param maxCustomers
	 * @param arriveInterval
	 * @param cashierMin
	 * @param cashierMax
	 * @param pickingMin
	 * @param pickingMax
	 * @param endTime
	 * @param seed
	 * @return
	 */
	private static StoreState runSimulation(
				int cashRegisters, int maxCustomers, double arriveInterval,
				double cashierMin, double cashierMax, double pickingMin,
				double pickingMax, double endTime, int seed) {

		StoreState s = new StoreState(cashRegisters, maxCustomers, arriveInterval, cashierMin, cashierMax, pickingMin, pickingMax, endTime, seed);
		
		EventQueue e = new EventQueue();
		e.addToQueue(new StartEvent(e, s, 0));
		
		Simulator simulator = new Simulator(s, e);
		simulator.run();
		
		return s;
	}
	
	/**
	 * METOD 2
	 * Optimizes the amount of chekouts that should be open for max efficiency.
	 * @param cashRegisters Amount of cash registers in the simulation.
	 * @param maxCustomers Max customers allowed in store.
	 * @param arriveInterval The interval for when customers arrive.
	 * @param cashierMin Minimum checkout time.
	 * @param cashierMax Maximum checkout time.
	 * @param pickingMin Minimum picking time.
	 * @param pickingMax Maxiumum picking time.
	 * @param endTime The end time.
	 * @param seed The seed of the simulation.
	 * @return The amount of cashiers that yield the best results
	 */
	private static int optimizeCashierAmount(
			int maxCustomers, double arriveInterval,
			double cashierMin, double cashierMax, double pickingMin,
			double pickingMax, double endTime, int seed) {
		
		int bestResult = 999;
		int bestResultIndex = 0;
		
		// Execute simulations
		for (int i = maxCustomers; i > 0; i--) {
			System.out.println("testing new simulation");
			StoreState r = runSimulation(i, maxCustomers, arriveInterval, cashierMin, cashierMax, pickingMin, pickingMax, endTime, seed);
			if (r.getTotalMissedCustomers() <= bestResult) {
				bestResultIndex = i;
				bestResult = r.getTotalMissedCustomers();
			} else {
				break;
			}
		}
		
		System.out.println(String.format("Optimize, kassor: %s, missad customers %s", bestResultIndex, bestResult));
		
		// Return amount of cashiers that yield the best results
		return bestResultIndex;
	}
	
	/**
	 * Metod 3
	 * @param maxCustomers Max customers allowed in store.
	 * @param arriveInterval The interval for when customers arrive.
	 * @param cashierMin Minimum checkout time.
	 * @param cashierMax Maximum checkout time.
	 * @param pickingMin Minimum picking time.
	 * @param pickingMax Maxiumum picking time.
	 * @param endTime The end time.
	 * @param seedRandomizer A randomizer of the seed.
	 * @return The seed with 
	 */
	private static int optimizeCashierAmountWithRandomSeed(int maxCustomers, double arriveInterval,
			double cashierMin, double cashierMax, double pickingMin,
			double pickingMax, double endTime, int seedRandomizer) {
		
		Random randomizer = new Random(seedRandomizer);
		int worst = 0;
		
		// Count up to 100 and restart if value changes.
		for (int i = 0; i < 100; i++) {
			int resultFound = optimizeCashierAmount(maxCustomers, arriveInterval, cashierMin, cashierMax, pickingMin, pickingMax, endTime, randomizer.nextInt());
			if (resultFound > worst) {
				i = 0;
				worst = resultFound;
			}
		}
		
		// return.
		return worst;
	}
}
