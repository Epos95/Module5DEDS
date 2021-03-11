package lab5.general;

/**
*<p>
*Extended by all specific events.
*Has an execute method to make the event happen.
*</p>
*@author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
*Max Agnesund.
 */
abstract public class Event {
	protected EventQueue queue;
	protected double occurenceTime;
	
	abstract public void execute();
}
