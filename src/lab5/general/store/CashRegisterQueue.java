package lab5.general.store;

import java.util.ArrayList;

/**
 * <p>
 * Queue of customers waiting to checkout.
 * </p>
 * 
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and Max
 *         Agnesund
 */
public class CashRegisterQueue {
	ArrayList<Customer> customerQueue = new ArrayList<>();

	/**
	 * @param customer A customers id.
	 */
	public void enqueue(Customer customer) {
		customerQueue.add(customer);
	}

	/**
	 * 
	 * @return
	 */
	public Customer dequeue() {
		Customer customer = customerQueue.get(0);
		customerQueue.remove(0);
		return customer;
	}

	/**
	 * @return The customer removed from the queue.
	 */
	public boolean isEmpty() {
		return customerQueue.size() == 0;
	}

	/**
	 * @return true if queue empty, false otherwise.
	 */
	public String toString() {
		String s = "[";

		for (int i = 0; i < customerQueue.size(); i++) {
			if (i != customerQueue.size() - 1) {
				s += customerQueue.get(i).toString() + ", ";
			} else {
				s += customerQueue.get(i).toString();
			}
		}
		
		/**
		 * @return The customers in queue as a string.
		 */
//    	for(Customer customer : customerQueue) {
//    		s += customer.toString() + ", ";
//    	}

		return s + "]";
	}
}
