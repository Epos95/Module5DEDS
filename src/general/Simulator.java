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
		
		///* F�r att testa att saker funkar nedan

		while (!state.isNotRunning) {
			if(queue.len() > 0) {

				queue.pop().execute();
				state.notifyObservers();

		}
	}
	}
	
}
