package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.GeneralEvent;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

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
        System.out.println("lmao");
        if(state.freeCashRegisters == 0) {
            // no open registers
            // add customer to queue of customers
            // maybe return here?
            state.cQueue.enqueue(this.cus);
            return;
        }

        // customer goes to the register
        state.freeCashRegisters -= 1;
        System.out.println("added new payevent");
        this.queue.addToQueue(new PayEvent(queue,cus,state.currentTime+state.cashierSpeed.getTime(),state));
    }

    @Override
    public double getTime() {
        return this.occurenceTime;
    }
}
