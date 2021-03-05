package Lab5.general;

import Lab5.general.store.StoreSimulatorViewer;

public class Simulator {
	
	public void run() {
		
	/* För att testa att saker funkar nedan
		
		State state = new State();
		EventQueue eventQueue = new EventQueue();
		StoreSimulatorViewer viewer = new StoreSimulatorViewer();
		viewer.startView();
		viewer.resultsView();
		
	*/
		while (!state.isNotRunning) {
			if(eventQueue.getQueue().size()>0) {
			
				eventQueue.getQueue().get(0).execute(state);
			
		}
	}
	}
	
}
