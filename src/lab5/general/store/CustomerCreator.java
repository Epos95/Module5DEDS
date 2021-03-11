package lab5.general.store;

/**
 * <p>
 * Creates customers and supplies them with an id.
 * </p>
 * 
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and Max
 *         Agnesund
 */
public class CustomerCreator {
	private int idIterator = 0;

	/**
	 * @return A new customer.
	 */
	public Customer getCustomer() {
		Customer customer = new Customer(idIterator);
		idIterator++;
		return customer;
	}
}
