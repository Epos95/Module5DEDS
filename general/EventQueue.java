package Lab5.general;

import java.util.ArrayList;

public class EventQueue {
	
	private ArrayList<Event> queue = new ArrayList<Event>();
	
	public ArrayList<Event> getQueue() {
		return queue;
	}
	
	void addToQueue(Event e) {
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
