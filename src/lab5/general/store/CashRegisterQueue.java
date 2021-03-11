package lab5.general.store;

import java.util.ArrayList;

public class CashRegisterQueue {
    ArrayList<Customer> customerQueue = new ArrayList<>();

    /**
     * 
     * @param customer
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
     * 
     * @return
     */
    public boolean isEmpty() {
        return customerQueue.size() == 0;
    }
    
    /**
     * 
     */
    public String toString() {
    	String s = "[";

    	for (int i = 0; i < customerQueue.size(); i++) {
    	    if (i != customerQueue.size() - 1) {
                s += customerQueue.get(i).toString() + ", ";
            }
    	    else {
                s += customerQueue.get(i).toString();
            }
        }
//    	for(Customer customer : customerQueue) {
//    		s += customer.toString() + ", ";
//    	}
    	
    	return s + "]";
    }
}
