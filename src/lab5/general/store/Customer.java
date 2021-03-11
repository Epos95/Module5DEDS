package lab5.general.store;

/**
 * <p>
 * Creates a customer with an id.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class Customer {
    private final int id;

    /**
     * @param newId the id of the new customer.
     */
    public Customer(int newId) {
        this.id = newId;
    }

    /**
     * @return The id as a string.
     */
    public String toString() {
        return Integer.toString(id);
    }
}
