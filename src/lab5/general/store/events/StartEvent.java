package lab5.general.store.events;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

/**
 * <p>
 * Event that starts the simulation.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class StartEvent extends Event {
    StoreState state;
    EventQueue queue;

    /**
     * Constructor for StartEvent.
     * @param q The event queue.
     * @param s The store state.
     * @param o The time for the event occurrence.
     */
    public StartEvent(EventQueue q, StoreState s, double o) {
        this.occurenceTime = o;
        this.queue = q;
        this.state = s;
    }

    /**
     * Makes the event happen.
     */
    @Override
    public void execute() {
    	state.updateTime(occurenceTime);

    	//
    	state.isOpen = true;
    	state.isRunning = true;
    	
    	//
		this.queue.addToQueue(new StoreCloseEvent(queue, state,
				this.state.OPENINGTIME + this.state.currentTime));
	
		//
    	if (state.currentCustomers < state.MAXCUSTOMERS) {
    		this.queue.addToQueue(new CustomerArrivedEvent(queue, state,
    				state.arrive.getTime() + state.currentTime,
    				state.newCustomer()));
    	}
        
    	state.sendUpdate("Start");
    }
}
