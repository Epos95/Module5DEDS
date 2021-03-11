package lab5.general.store.events;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

public class StartEvent extends Event {
    StoreState state;
    EventQueue queue;

    /**
     * 
     * @param q
     * @param s
     * @param o
     */
    public StartEvent(EventQueue q, StoreState s, double o) {
        this.occurenceTime = o;
        this.queue = q;
        this.state = s;
    }

    /**
     * 
     */
    @Override
    public void execute() {
    	double timeDelta = this.occurenceTime - state.currentTime;
    	state.currentTime = this.occurenceTime;
    	// TODO: Time elapsed.

    	// Stäng efter en viss tid.
		this.queue.addToQueue(new StoreCloseEvent(queue, state, this.state.openingTime + this.state.currentTime));
	
		// Ny kund
    	if (state.currentCustomers < state.maxCustomers) {
    		Customer c = state.newCustomer();
    		this.queue.addToQueue(new CustomerArrivedEvent(queue, state, state.arrive.getTime()+state.currentTime,c));
    	}
        
    	
    	
        state.notifyObservers();
    }
}
