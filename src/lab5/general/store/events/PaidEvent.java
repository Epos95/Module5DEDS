package lab5.general.store.events;

import lab5.general.EventQueue;
import lab5.general.Event;
import lab5.general.store.Customer;
import lab5.general.store.StoreState;

public class PaidEvent extends Event {

    Customer customer;
    StoreState state;

    /**
     * 
     * @param q
     * @param s
     * @param o
     * @param c
     */
    public PaidEvent(EventQueue q, StoreState s, double o, Customer c) {
        // generate time and stuff
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
    	state.updateTime(occurenceTime);
    	
        state.currentCustomers -= 1;
        state.paidCustomer();
        
        //
        if (state.cQueue.isEmpty()) {
        	
        	// no one is in queue, register opens up
        	state.freeCashRegisters += 1;
        	
        	//
        	if (!state.isOpen) {
        		this.queue.push(new EndEvent(this.queue, this.state, this.occurenceTime));
        	}
        	
        } else {
        	
        	//
        	state.cQueue.dequeue();
            this.queue.push(new PaidEvent(this.queue, state, state.cashierSpeed.getTime()+state.currentTime, this.customer));
        }
    }
}