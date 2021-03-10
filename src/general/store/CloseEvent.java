package general.store;

import general.GeneralEndEvent;
import general.GeneralEvent;
import general.EventQueue;
import general.State;

public class CloseEvent extends GeneralEndEvent {

    public CloseEvent(EventQueue q) {
        this.occurenceTime = -1;
        this.queue = q;
    }

    @Override
    public void execute(State state) {
        // closes the store
        state.isOpen = false;
    }

    @Override
    public double getTime() {
        return 0;
    }
}
