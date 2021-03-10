package general.store.events;

import general.GeneralEvent;
import general.EventQueue;
import general.State;
import general.store.Customer;
import general.store.StoreState;

public class PickEvent extends GeneralEvent {

    Customer cus;
    StoreState state;
    // this event might not need the event que?
    public PickEvent(EventQueue q, Customer c, double time, StoreState s) {
        // generate time here somehow
        this.occurenceTime = time;
        this.queue = q;
        this.cus = c;
        this.state = s;
    }

    @Override
    public void execute() {
        state.currentTime = this.occurenceTime;
        if(state.freeCashRegisters == 0) {
            // no open registers
            // add customer to queue of customers
            // maybe return here?
            state.cQueue.add(this.cus);
            return;
        }

        // customer goes to the register
        state.freeCashRegisters -= 1;
    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
