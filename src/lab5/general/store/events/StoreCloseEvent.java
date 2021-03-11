package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.GeneralEvent;
import lab5.general.State;
import lab5.general.store.StoreState;

public class CloseEvent extends GeneralEvent {

    StoreState state;

    public CloseEvent(EventQueue q, double time, StoreState s) {
        this.occurenceTime = time;
        this.queue = q;
        this.state = s;
    }

    @Override
    public void execute() {
        state.currentTime = this.occurenceTime;
        // closes the store
        state.isOpen = false;
    }

    @Override
    public double getTime() {
        return 0;
    }
}
