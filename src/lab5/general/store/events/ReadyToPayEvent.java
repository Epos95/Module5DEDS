package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

public class ReadyToPayEvent extends Event {

    Customer customer;
    StoreState state;
    
    /**
     * 
     * @param q
     * @param s
     * @param time
     * @param c
     */
    public ReadyToPayEvent(EventQueue q, StoreState s, double time, Customer c) {
        // generate time here somehow
        this.occurenceTime = time;
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
    	
        System.out.println("lmao");
        if(state.freeCashRegisters == 0) {
            // no open registers
            // add customer to queue of customers
            // maybe return here?
            state.cQueue.enqueue(this.customer);
            return;
        }

        // customer goes to the register
        state.freeCashRegisters -= 1;
        System.out.println("added new payevent");
        this.queue.addToQueue(new PaidEvent(queue,state,state.currentTime+state.cashierSpeed.getTime(),customer));
    }
}
