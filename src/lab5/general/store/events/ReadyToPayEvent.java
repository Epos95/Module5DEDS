package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

public class ReadyToPayEvent extends Event {

	Customer customer;
	StoreState state;

	/**
	 * 
	 * @param q
	 * @param s
	 * @param time
	 * @param c
	 */
	public ReadyToPayEvent(EventQueue q, StoreState s, double time, Customer c) {
		// generate time here somehow
		this.occurenceTime = time;
		this.queue = q;
		this.customer = c;
		this.state = s;
	}

	/**
	 * 
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
					new PaidEvent(queue, state, state.currentTime + state.cashierSpeed.getTime(), customer));
		}

		state.sendUpdate("Plock", customer.toString());
	}
}
