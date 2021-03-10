package general.store.events;

import general.GeneralEvent;
import general.EventQueue;
import general.State;
import general.store.Customer;

public class CustomerArrivedEvent extends GeneralEvent {

    Customer cus;

    public CustomerArrivedEvent(EventQueue q, Customer c, double time) {
        // generate the occurencetime randomly
        this.occurenceTime = time;
        this.queue = q;
        this.cus = c;
    }

    @Override
    public void execute(State state) {
        state.currentTime = this.occurenceTime;

        if (!state.isOpen) {
            // store is closed
            // update state and return
            state.missedCustomer();
            return;
        } else {
            // aslong as the store is open we should generate new arrival events
            this.queue.push(new CustomerArrivedEvent(this.queue, state.newCustomer(), state.arrive.getTime()+state.currentTime));
        }

        if (state.currentCustomers == state.maxCustomers) {
            // store has too many customers

            // update state and return
            state.missedCustomer();
            return;
        }

        // customer got let in
        state.currentCustomers += 1;

        // generate PickEvent
        this.queue.push(new PickEvent(this.queue, this.cus, state.pickingTime.getTime()));
        // time might be fucky wucky here

    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}