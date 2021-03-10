package general;

import general.store.StoreSimulatorViewer;
import general.store.StoreState;
import general.store.events.StartEvent;

public class Simulator {
	State state;
	EventQueue queue;

    public Simulator(State s, EventQueue q ) {
    	this.state = s;
    	this.queue = q;
	}
	
	public void run() {

		
		while (!state.isNotRunning) {
			if(queue.len() > 0) {
			    System.out.println(queue.len());

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				queue.pop().execute();
				state.notifyObservers();
			} else {
				break;
			}
		}
	}
	
}
