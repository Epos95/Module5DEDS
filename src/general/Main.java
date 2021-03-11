package general;

import general.store.StoreSimulatorViewer;
import general.store.StoreState;
import general.store.events.StartEvent;

public class Main {

	public static void main(String[] args) {

		StoreState s = new StoreState(2, 5, 1.0,
				2, 3, 0.5, 1.0, 0, 1234
		);

		StoreSimulatorViewer v = new StoreSimulatorViewer(s);
		s.addObserver(v);
		System.out.println("Simuleringsexempel 1\n");
		v.startView();

		s.isOpen = true;
		EventQueue e = new EventQueue();
		e.addToQueue(new StartEvent(e, s));
		Simulator simulator = new Simulator(s, e);
		simulator.run();
		v.resultsView();
		
	}
	

}
