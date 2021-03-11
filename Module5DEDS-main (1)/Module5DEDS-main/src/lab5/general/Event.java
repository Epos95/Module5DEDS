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
	
	/**
	 * Base for the "performe me" method of all events.
	 */
	abstract public void execute();
}
