package general.store.events;

import general.EventQueue;
import general.GeneralEvent;
import general.State;
import general.store.Customer;

public class StartEvent extends GeneralEvent {

    public StartEvent(EventQueue q) {
        // time should be set as the start time (0)
        this.occurenceTime = 0;
        this.queue = q;
    }

    @Override
    public void execute(State state) {
        state.currentTime = this.occurenceTime;

        // add a "customerArrivedEvent" to queue
        Customer c = state.newCustomer();
        this.queue.push(new CustomerArrivedEvent(queue, c, state.arrive.getTime()+state.currentTime));

        state.updateView();
    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
