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
    	state.updateTime(occurenceTime);
    	
        // closes the store
        state.isOpen = false;
        
        // 
        if (state.currentCustomers == 0) {
        	state.closeStore();
        	queue.addToQueue(new EndEvent(queue, state, 999));
        }
        
        state.sendUpdate("Stänger");
    }
}
