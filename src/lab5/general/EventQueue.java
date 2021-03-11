package lab5.general;

import java.util.ArrayList;

public class EventQueue {
	
	private ArrayList<Event> queue = new ArrayList<Event>();

	/**
	 * 
	 * @return
	 */
	public int len() {
		return queue.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public Event pop() {
		Event e = queue.get(0);
		queue.remove(0);

		return e;
	}

	/**
	 * 
	 * @param e
	 */
	public void push(Event e) {
		addToQueue(e);
	}


	/**
	 * 
	 * @param e
	 */
	public void addToQueue(Event e) {
		if (queue.size() == 0) {
			queue.add(e);
		}
		else {
			for(int i = 0; i<queue.size(); i++) {
				if (queue.get(i).occurenceTime > e.occurenceTime) {
					queue.add(i, e);
					break;
				}
			}
		}
	}
}
