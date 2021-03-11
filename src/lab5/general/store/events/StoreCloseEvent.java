package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.State;
import lab5.general.store.StoreState;

public class StoreCloseEvent extends Event {

    StoreState state;

    /**
     * 
     * @param q
     * @param s
     * @param o
     */
    public StoreCloseEvent(EventQueue q, StoreState s, double o) {
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
    	
        // closes the store
        state.isOpen = false;
    }
}
