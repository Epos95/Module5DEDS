
package lab5.general.store;

import java.util.Random;

public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * 
	 * @param lower
	 * @param upper
	 * @param seed
	 */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * 
	 * @param lower
	 * @param upper
	 */
	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * 
	 * @return
	 */
	public double next() {
		return lower + rand.nextDouble() * width;
	}
}
