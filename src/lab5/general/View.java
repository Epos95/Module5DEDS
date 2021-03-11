package lab5.general;

/**
 * <p>
 * Base view extended by specific views.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public abstract class View implements Observer {
	
	/**
	 * Base update.
	 * Used to update the view whenever a change in the state occurs.
	 */
	public void update(Observable o, Object arg) {}
}
