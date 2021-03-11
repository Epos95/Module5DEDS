package lab5.general.store;

import java.util.ArrayList;

public class CashRegisterQueue {
    private ArrayList<Customer> customerQueue = new ArrayList<>();

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
}
