package general.store;

import java.util.ArrayList;

public class CashRegisterQueue {
    ArrayList<Customer> customerQueue = new ArrayList<>();

    public void add(Customer customer) {
        customerQueue.add(customer);
    }

    public boolean isEmpty() {
        return customerQueue.size() == 0;
    }

    public boolean dequeue() {
        if (customerQueue.size() >= 1) {
            customerQueue.remove(0);
            return true;
        }
        else {
            return false;
        }
    }
}
