package lab5.general.store;

public class Customer {
    private final int id;

    /**
     * 
     * @param newId
     */
    public Customer(int newId) {
        this.id = newId;
    }

    /**
     * 
     */
    public String toString() {
        return Integer.toString(id);
    }
}
