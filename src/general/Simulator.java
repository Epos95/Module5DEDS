package general;

import general.store.StoreSimulatorViewer;
import general.store.StoreState;

public class Simulator {
	State state;

    public Simulator(State s) {
    	this.state = s;
	}
	
	public void run() {
		
		///* F�r att testa att saker funkar nedan

		EventQueue eventQueue = new EventQueue();

		while (!state.isNotRunning) {
			if(eventQueue.len() > 0) {
			
				eventQueue.pop().execute();
				state.notifyObservers();

		}
	}
	}
	
}
