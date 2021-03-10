package general.store;

import general.GeneralEvent;
import general.EventQueue;
import general.State;

public class CustomerArrivedEvent extends GeneralEvent {

    public CustomerArrivedEvent(EventQueue q) {
        // generate the occurencetime randomly
        this.occurenceTime = -1;
        this.queue = q;
    }

    @Override
    public void execute(State state) {

        if (!state.isOpen) {
            // store is closed
            // update state and return
            state.missedCustomer();
            return;
        } else {
            // aslong as the store is open we should generate new arrival events
            this.queue.push(new CustomerArrivedEvent(this.queue));
        }

        if (state.currentCustomers == state.maxCustomers) {
            // store has too many customers

            // update state and return
            return;
        }

        // customer got let in
        state.currentCustomers += 1;

        // generate PickEvent
        this.queue.push(new PickEvent(this.queue));
        // time might be fucky wucky here

    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
