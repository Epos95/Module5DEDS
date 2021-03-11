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
		
		
		System.out.println("Simuleringsexempel 1\n");
		StoreState s = new StoreState(
				2, // Cashregisters
				5, // Max customers
				1.0, // Arrive Interval
				2, // CashierMin
				3, // CashierMax
				0.5, // PickingMin
				1.0, // PickingMax
				10, // OpeningTime
				1234 // Seed
		);
		
	
		/*System.out.println("Simuleringsexempel 2\n");
		StoreState s = new StoreState(
				2, // Cashregisters
				7, // Max customers
				3.0, // Arrive Interval
				0.35, // CashierMin
				0.6, // CashierMax
				0.6, // PickingMin
				0.9, // PickingMax
				8, // OpeningTime
				13 // Seed
		);*/
		
		
		// Vy
		StoreSimulationViewer v = new StoreSimulationViewer(s);
		s.addObserver(v);
		v.startView();

		// Kö
		EventQueue e = new EventQueue();
		e.addToQueue(new StartEvent(e, s, 0));
		
		// Kör
		Simulator simulator = new Simulator(s, e);
		simulator.run();
		
		// Resultat
		v.resultsView();
		
	}

}
