package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.State;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

/**
 * <p>
 * Arrival event.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */

public class CustomerArrivedEvent extends Event {

    Customer customer;
    StoreState state;

    /**
     * Constructor for CustomerArrivedEvent.
     * @param q The event queue.
     * @param c The store state.
     * @param o Time of arrival.
     * @param s The arriving customer.
     */
    public CustomerArrivedEvent(EventQueue q, StoreState s, double o, Customer c) {
        this.occurenceTime = o;
        this.queue = q;
        this.customer = c;
        this.state = s;
    }

    /**
     * Method to make the arrival event occur.
     */
    @Override
    public void execute() {
		state.updateTime(occurenceTime);
    	
    	// aslong as the store is open we should generate new arrival events
        if (state.isOpen) {
            this.queue.addToQueue(new CustomerArrivedEvent(this.queue, state, state.arrive.getTime() + state.currentTime, state.newCustomer()));
        
	        // store has too many customers
	        if (state.currentCustomers == state.MAXCUSTOMERS) {
	            state.missedCustomer();
	        } else {
	        	
	        	// generate PickEvent
	            state.currentCustomers += 1;
		        this.queue.addToQueue(new ReadyToPayEvent(this.queue, state, state.pickingTime.getTime()+state.currentTime, this.customer));
	        }
        }
        
        state.sendUpdate("Ankomst", customer.toString());
    }
}
