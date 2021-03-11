package lab5.general.store.events;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.store.StoreState;

/**
 * <p>
 * Event that stops the simulation.
 * </p>
 * 
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and Max
 *         Agnesund
 */
public class EndEvent extends Event {
	StoreState state;
	EventQueue queue;

	/**
	 * Constructor for EndEvent.
	 * 
	 * @param q The event queue.
	 * @param s The store state.
	 * @param o Time of end.
	 */
	public EndEvent(EventQueue q, StoreState s, double o) {
		this.occurenceTime = o;
		this.queue = q;
		this.state = s;
	}

	/**
	 * Method to make the method occur. Stops the simulation.
	 */
	@Override
	public void execute() {
		state.isNotRunning = true;
		state.updateTime(occurenceTime);
		state.sendUpdate("Stop");
	}
}
