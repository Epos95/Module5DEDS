package general.store.events;

import general.GeneralEndEvent;
import general.GeneralEvent;
import general.EventQueue;
import general.State;

public class CloseEvent extends GeneralEndEvent {

    public CloseEvent(EventQueue q, double time) {
        this.occurenceTime = time;
        this.queue = q;
    }

    @Override
    public void execute(State state) {
        state.currentTime = this.occurenceTime;
        // closes the store
        state.isOpen = false;
    }

    @Override
    public double getTime() {
        return 0;
    }
}
