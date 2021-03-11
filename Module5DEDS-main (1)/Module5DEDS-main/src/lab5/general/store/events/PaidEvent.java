package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;


/**
 * <p>
 * Event for a customer paying at the checkout.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class PaidEvent extends Event {

    Customer customer;
    StoreState state;

    /**
     * Constructor for paidEvent.
     * @param q The event queue.
     * @param s The state of the store.
     * @param o Time of event happening.
     * @param c Customer performing event.
     */
    public PaidEvent(EventQueue q, StoreState s, double o, Customer c) {
        // generate time and stuff
        this.occurenceTime = o;
        this.queue = q;
        this.customer = c;
        this.state = s;
    }

    /**
     * Method that makes the paying event happen.
     */
    @Override
    public void execute() {
    	state.updateTime(occurenceTime);
    	
        state.currentCustomers -= 1;
        state.paidCustomer();
        
        //
        if (state.cQueue.isEmpty()) {
        	
        	// no one is in queue, register opens up
        	state.openRegister();
        	
        	//
        	if (!state.isOpen && state.currentCustomers == 0) {
        		state.closeStore();
        		this.queue.push(new EndEvent(this.queue, this.state, 999));
        	}
        	
        } else {
        	
        	//
            this.queue.push(new PaidEvent(this.queue, state, state.cashierSpeed.getTime()+state.currentTime, state.cQueue.dequeue()));
        }
        
        state.sendUpdate("Betalning", customer.toString());
    }
}
