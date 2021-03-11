package lab5.general;

/**
 * <p>
 * Keeps the simulation running with the run method.
 * Continues untill inNotRunning from state is true.
 * </p>
 *@author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
*Max Agnesund.
 */
public class Simulator {
	State state;
	EventQueue queue;

	/**
	 * Constructor for Simulator.
	 * @param s The state of the simulation.
	 * @param q The event queue of the simulation.
	 */
    public Simulator(State s, EventQueue q ) {
    	this.state = s;
    	this.queue = q;
	}
	
    /**
     * Starts the simulation and keeps it going untill a stop method is called.
     */
	public void run() {
		while (!state.isNotRunning) {
			if(queue.len() > 0) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				queue.pop().execute();
			} else {
				break;
			}
		}
	}
}
