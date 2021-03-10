package general.store;

import general.GeneralEvent;
import general.EventQueue;
import general.State;

public class PayEvent extends GeneralEvent {

    public PayEvent(EventQueue q) {
        // generate time and stuff
        this.occurenceTime = -1;
        this.queue = q;
    }

    @Override
    public void execute(State state) {
        state.currentCustomers -= 1;

        if (!state.cQueue.isEmpty()) {
            state.cQueue.dequeue();
            this.queue.push(new PayEvent(this.queue));
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
