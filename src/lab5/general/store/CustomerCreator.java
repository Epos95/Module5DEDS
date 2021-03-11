package lab5.general.store;

public class CustomerCreator {
    private int idIterator = 0;

    /**
     * 
     * @return
     */
    public Customer getCustomer() {
        Customer customer = new Customer(idIterator);
        idIterator++;
        return customer;
    }
}
