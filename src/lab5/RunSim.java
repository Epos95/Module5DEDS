package lab5;

import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.store.StoreSimulatorViewer;
import lab5.general.store.StoreState;
import lab5.general.store.events.StartEvent;

public class RunSim {

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
