package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.State;
import lab5.general.store.StoreState;

public class StoreCloseEvent extends Event {

    StoreState state;

    /**
     * Constructor for the StoreCloseEvent.
     * @param q The event queue.
     * @param s The store state.
     * @param o The time for the event happening.
     */
    public StoreCloseEvent(EventQueue q, StoreState s, double o) {
        this.occurenceTime = o;
        this.queue = q;
        this.state = s;
    }

    /**
     * Makes events happen by closing the store.
     */
    @Override
    public void execute() {
    	state.updateTime(occurenceTime);

        state.sendUpdate("Stänger");
        // closes the store
        state.isOpen = false;
        
        // 
        if (state.currentCustomers == 0) {
        	state.closeStore();
        	queue.addToQueue(new EndEvent(queue, state, 999));
        }
        
    }
}
