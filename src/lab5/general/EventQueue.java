package lab5.general;

import java.util.ArrayList;

public class EventQueue {
	
	private ArrayList<GeneralEvent> queue = new ArrayList<GeneralEvent>();

	public int len() {
		return queue.size();
	}
	public GeneralEvent pop() {
		GeneralEvent e = queue.get(0);
		queue.remove(0);

		return e;
	}

	public void push(GeneralEvent e) {
		addToQueue(e);
	}


	// maybe redo this sorting algo?
	public void addToQueue(GeneralEvent e) {
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
		System.out.println("added new thing");
	}

}
