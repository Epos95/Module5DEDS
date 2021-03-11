package lab5.general.store;

public class CustomerCreator {
    private int idIterator = 0;

    public Customer getCustomer() {
        Customer customer = new Customer(idIterator);
        idIterator++;
        return customer;
    }
}
