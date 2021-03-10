package general;


import general.store.StoreSimulatorViewer;
import general.store.StoreState;
import general.store.events.StartEvent;

public class Main {

	public static void main(String[] args) {

		StoreState s = new StoreState(
				4,
				50,
				1,
				2,
				4,
				1,
				5,
				0,
				1234
		);

		StoreSimulatorViewer v = new StoreSimulatorViewer();
		s.addObserver(v);
		v.startView();

		EventQueue e = new EventQueue();
		e.addToQueue(new StartEvent(e, s));
		Simulator simulator = new Simulator(s, e);
		simulator.run();
		v.resultsView();
		
	}
	

}
