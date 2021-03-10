package general;

abstract public class GeneralEvent {
	protected EventQueue queue;
	protected double occurenceTime;
	
	abstract public void execute(State state);
	abstract public double getTime();
}
