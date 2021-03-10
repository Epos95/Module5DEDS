package general.store;

import general.GeneralEvent;
import general.EventQueue;
import general.State;

public class StartEvent extends GeneralEvent {

    public StartEvent(EventQueue q) {
        // time should be set as the start time (0)
        this.occurenceTime = 0;
        this.queue = q;
    }

    @Override
    public void execute(State state) {

        // add a "customerArrivedEvent" to queue
        this.queue.push(new CustomerArrivedEvent(queue));

    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
