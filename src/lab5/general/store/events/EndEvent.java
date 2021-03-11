package lab5.general.store.events;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.store.StoreState;

public class EndEvent extends Event {
    StoreState state;
    EventQueue queue;

    /**
     * 
     * @param q
     * @param s
     * @param o
     */
    public EndEvent(EventQueue q, StoreState s, double o) {
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
    	state.isNotRunning = true;
    	
    	state.sendUpdate("Stop");
    }
}
