package lab5.general;

import java.util.ArrayList;

/**
*<p>
*A queue with all the events about to happen where the event
*that's next to occur is in front of the queue.
*</p>
*@author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
*Max Agnesund
*/
public class EventQueue {
	
	private ArrayList<Event> queue = new ArrayList<Event>();

	/**
	 * Returns the length of the event queue.
	 * @return Length of the event queue.
	 */
	public int len() {
		return queue.size();
	}
	
	/**
	 * Removes the next event to be executed from queue.
	 * @return The removed event from the queue.
	 */
	public Event pop() {
		Event e = queue.get(0);
		queue.remove(0);
		return e;
	}

	/**
	 * Adds an event to the event queue.
	 * @param e An event.
	 */
	public void push(Event e) {
		addToQueue(e);
	}


	/**
	 * Adds an event to the queue and in the order in which it is to be exectued.
	 * @param e Event to be added to the event queue.
	 */
	public void addToQueue(Event e) {
		if (queue.size() == 0) {
			queue.add(e);
		}
		else {
			for(int i = 0; i < queue.size(); i++) {
				if (queue.get(i).occurenceTime > e.occurenceTime) {
					queue.add(i, e);
					return;
				}
			}
			queue.add(e);
		}
	}
}
