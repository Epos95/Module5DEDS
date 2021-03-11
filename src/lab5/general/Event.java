package lab5.general;

abstract public class GeneralEvent {
	protected EventQueue queue;
	protected double occurenceTime;
	
	abstract public void execute();
	abstract public double getTime();
}
