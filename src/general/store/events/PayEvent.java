package general.store.events;

import general.GeneralEvent;
import general.EventQueue;
import general.State;
import general.store.Customer;
import general.store.StoreState;

public class PayEvent extends GeneralEvent {

    Customer cus;
    StoreState state;

    public PayEvent(EventQueue q, Customer c, double time, StoreState s) {
        // generate time and stuff
        this.occurenceTime = time;
        this.queue = q;
        this.cus = c;
        this.state = s;
    }

    @Override
    public void execute() {
        state.currentTime = this.occurenceTime;
        state.currentCustomers -= 1;

        if (!state.cQueue.isEmpty()) {
            state.cQueue.dequeue();
            this.queue.push(new PayEvent(this.queue, cus, state.cashierSpeed.getTime()+state.currentTime, state));
        } else {
            // no one is in queue, register opens up
            state.freeCashRegisters += 1;
        }

    }

    @Override
    public double getTime() {
        return 0;
    }
}
