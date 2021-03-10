package general;


import general.store.StoreSimulatorViewer;
import general.store.StoreState;

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
		Simulator simulator = new Simulator(s);
		simulator.run();
		v.resultsView();
		
	}
	

}
