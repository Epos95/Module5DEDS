package general;

import general.store.StoreSimulatorViewer;
import general.store.StoreState;

public class Simulator {
	
	public void run() {
		

		State state = new State();
		EventQueue eventQueue = new EventQueue();
		StoreSimulatorViewer viewer = new StoreSimulatorViewer(state);
		viewer.startView();
		viewer.resultsView();
		state.addObserver(viewer);

		while (!state.isNotRunning) {
			if(eventQueue.len() > 0) {
			
				eventQueue.pop().execute(state);
				state.updateView();

		}
	}
	}
	
}
