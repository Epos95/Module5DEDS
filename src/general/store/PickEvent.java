package general.store;

import general.GeneralEvent;
import general.EventQueue;
import general.State;

public class PickEvent extends GeneralEvent {

    // this event might not need the event que?
    public PickEvent(EventQueue q) {
        // generate time here somehow
        this.occurenceTime = -1; // TODO
        this.queue = q;
    }

    @Override
    public void execute(State state) {
        if(state.freeCashRegisters == 0) {
            // no open registers
            // add customer to queue of customers
            // maybe return here?
            //state.cQueue.add();
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
