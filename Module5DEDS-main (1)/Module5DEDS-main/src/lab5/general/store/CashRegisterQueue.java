package lab5.general.store;

import java.util.ArrayList;

/**
 * <p>
 * Queue of customers waiting to checkout.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */

public class CashRegisterQueue {
    ArrayList<Customer> customerQueue = new ArrayList<>();

    /**
     * 
     * @param customer A customers id.
     */
    public void enqueue(Customer customer) {
        customerQueue.add(customer);
    }

    /**
     * 
     * @return The customer removed from the queue.
     */
    public Customer dequeue() {
        Customer customer = customerQueue.get(0);
        customerQueue.remove(0);
        return customer;
    }

    /**
     * 
     * @return true if queue empty, false otherwise.
     */
    public boolean isEmpty() {
        return customerQueue.size() == 0;
    }
    
    /**
     * @return The customers in queue as a string.
     */
    public String toString() {
    	String s = "[ ";
    	
    	for(Customer customer : customerQueue) {
    		s += customer.toString() + " ";
    	}
    	
    	return s + "]";
    }
}
