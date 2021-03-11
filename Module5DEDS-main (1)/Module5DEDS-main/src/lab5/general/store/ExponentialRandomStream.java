
package lab5.general.store;

import java.util.Random;

/**
 * <p>
 * Generates random numbers.
 * </p>
 * 
 */

public class ExponentialRandomStream {
	
	private Random rand;
	private double lambda;
	  
	/**
	 * 
	 * @param lambda Avarage customers arraving at a time interval.
	 * @param seed Seed of the simulation.
	 */
	public ExponentialRandomStream(double lambda, long seed) {
	  	rand = new Random(seed);
	  	this.lambda = lambda;
	}
	  
	/**
	 * 
	 * @param lambda Avarage customers arraving at a time interval.
	 */
	public ExponentialRandomStream(double lambda) {
		rand = new Random();
	    this.lambda = lambda;
	}
	  
	/**
	 * 
	 * @return 
	 */
	public double next() {
	  	return -Math.log(rand.nextDouble())/lambda;
	}
}

