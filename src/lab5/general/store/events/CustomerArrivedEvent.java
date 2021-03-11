package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.State;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

public class CustomerArrivedEvent extends Event {

    Customer customer;
    StoreState state;

    /**
     * 
     * @param q
     * @param c
     * @param time
     * @param s
     */
    public CustomerArrivedEvent(EventQueue q, StoreState s, double o, Customer c) {
        this.occurenceTime = o;
        this.queue = q;
        this.customer = c;
        this.state = s;
    }

    /**
     * 
     */
    @Override
    public void execute() {
    	double timeDelta = this.occurenceTime - state.currentTime;
    	state.currentTime = this.occurenceTime;
    	// TODO: Time elapsed.

        if (!state.isOpen) {
            // store is closed
            // update state and return
            state.missedCustomer();
            return;
        } else {
            // aslong as the store is open we should generate new arrival events
            System.out.println("custom arrived event added new customer arrived event");
            this.queue.addToQueue(new CustomerArrivedEvent(this.queue, state, state.arrive.getTime()+state.currentTime, state.newCustomer()));
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
        this.queue.addToQueue(new ReadyToPayEvent(this.queue, state, state.pickingTime.getTime()+ state.currentTime, this.customer));
        // time might be fucky wucky here

    }
}
