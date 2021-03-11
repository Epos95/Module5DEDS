package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.GeneralEvent;
import lab5.general.State;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

public class CustomerArrivedEvent extends GeneralEvent {

    Customer cus;
    StoreState state;

    public CustomerArrivedEvent(EventQueue q, Customer c, double time, StoreState s) {
        // generate the occurencetime randomly
        this.occurenceTime = time;
        this.queue = q;
        this.cus = c;
        this.state = s;
    }

    @Override
    public void execute() {
        state.currentTime = this.occurenceTime;

        if (!state.isOpen) {
            // store is closed
            // update state and return
            state.missedCustomer();
            return;
        } else {
            // aslong as the store is open we should generate new arrival events
            System.out.println("custom arrived event added new customer arrived event");
            this.queue.addToQueue(new CustomerArrivedEvent(this.queue, state.newCustomer(), state.arrive.getTime()+state.currentTime, state));
        }

        if (state.currentCustomers == state.maxCustomers) {
            // store has too many customers

            // update state and return
            System.out.println("missed customer!");
            state.missedCustomer();
            return;
        }

        // customer got let in
        state.currentCustomers += 1;

        // generate PickEvent
        System.out.println("custom arrived event added new pick event");
        this.queue.addToQueue(new PickEvent(this.queue, this.cus, state.pickingTime.getTime()+ state.currentTime, state));
        // time might be fucky wucky here

    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
