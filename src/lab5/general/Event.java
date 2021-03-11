package lab5.general;

abstract public class Event {
	protected EventQueue queue;
	protected double occurenceTime;
	
	abstract public void execute();
}
