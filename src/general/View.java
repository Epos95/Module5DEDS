package general;
import java.util.Observable;
import java.util.Observer;

public abstract class View implements Observer{

	@Override
	abstract public void update(Observable o, Object arg);
	

}
