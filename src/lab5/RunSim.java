package lab5;

import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.store.StoreSimulationViewer;
import lab5.general.store.StoreState;
import lab5.general.store.events.StartEvent;

public class RunSim {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StoreState s = new StoreState(2, 5, 1.0,
				2, 3, 0.5, 1.0, 0, 1234
		);

		StoreSimulationViewer v = new StoreSimulationViewer(s);
		s.addObserver(v);
		
		System.out.println("Simuleringsexempel 1\n");
		v.startView();

		EventQueue e = new EventQueue();
		e.addToQueue(new StartEvent(e, s, 0));
		Simulator simulator = new Simulator(s, e);
		simulator.run();
		
		v.resultsView();
	}

}
