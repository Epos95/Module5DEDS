package general.store;

import java.util.ArrayList;

public class CashRegisterQueue {
    private ArrayList<Customer> customerQueue = new ArrayList<>();

    public void enqueue(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer dequeue() {
        Customer customer = customerQueue.get(0);
        customerQueue.remove(0);
        return customer;
    }

    public boolean isEmpty() {
        return customerQueue.size() == 0;
    }
}
