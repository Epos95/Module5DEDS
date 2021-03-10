package general.store.events;

import general.GeneralEvent;
import general.EventQueue;
import general.State;
import general.store.Customer;

public class PayEvent extends GeneralEvent {

    Customer cus;

    public PayEvent(EventQueue q, Customer c, double time) {
        // generate time and stuff
        this.occurenceTime = time;
        this.queue = q;
        this.cus = c;
    }

    @Override
    public void execute(State state) {
        state.currentTime = this.occurenceTime;
        state.currentCustomers -= 1;

        if (!state.cQueue.isEmpty()) {
            state.cQueue.dequeue();
            this.queue.push(new PayEvent(this.queue, cus, state.cashierSpeed.getTime()+state.currentTime));
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
