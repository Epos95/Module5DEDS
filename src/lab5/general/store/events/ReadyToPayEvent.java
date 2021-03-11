package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

/**
 * <p>
 * Event For a customer that has picked his wares and is ready to pay.
 * </p>
 * 
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and Max
 *         Agnesund
 */
public class ReadyToPayEvent extends Event {

	Customer customer;
	StoreState state;

	/**
	 * Constructor for readyToPayEvent.
	 * 
	 * @param q    The event queue.
	 * @param s    The store state.
	 * @param time Time of event occurring.
	 * @param c    THe customer that perform this event.
	 */
	public ReadyToPayEvent(EventQueue q, StoreState s, double time,
			Customer c) {
		// generate time here somehow
		this.occurenceTime = time;
		this.queue = q;
		this.customer = c;
		this.state = s;
	}

	/**
	 * <p>
	 * Puts the customer in the cash register queue if there's none available.
	 * Otherwise allows customer to pay.
	 * </p>
	 */
	@Override
	public void execute() {
		state.updateTime(occurenceTime);

		// no open registers
		// add customer to queue of customers
		if (state.freeCashRegisters == 0) {
			state.cQueue.enqueue(this.customer);
			state.queuedCustomer();
		} else {
			state.closeRegister();
			this.queue.addToQueue(
					new PaidEvent(queue, state, state.currentTime +
							state.cashierSpeed.getTime(), customer));
		}

		state.sendUpdate("Plock", customer.toString());
	}
}
