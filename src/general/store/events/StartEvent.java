package general.store.events;

import general.EventQueue;
import general.GeneralEvent;
import general.State;
import general.store.Customer;
import general.store.StoreState;

public class StartEvent extends GeneralEvent {
    StoreState state;
    EventQueue queue;

    public StartEvent(EventQueue q, StoreState s) {
        // time should be set as the start time (0)
        this.occurenceTime = 0;
        this.queue = q;
        this.state = s;
    }

    @Override
    public void execute() {
        state.currentTime = this.occurenceTime;

        Customer c = state.newCustomer();
        this.queue.addToQueue(new CustomerArrivedEvent(queue, c, state.arrive.getTime()+state.currentTime,state));

        state.notifyObservers();
    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
