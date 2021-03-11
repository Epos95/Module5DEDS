package lab5;

import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.store.StoreSimulationViewer;
import lab5.general.store.StoreState;
import lab5.general.store.events.StartEvent;

/**
 * <p>
 * Contains main method.
 * Creates necessary objects for the simulation and runs the run method
 * of the simulation class to initiate the simulation.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */
public class RunSim {

	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		

		/*
		System.out.println("Simuleringsexempel 1\n");
		StoreState s = new StoreState(
				2, // Cash registers
				5, // Max customers
				1.0, // Arrive Interval
				2, // CashierMin
				3, // CashierMax
				0.5, // PickingMin
				1.0, // PickingMax
				10, // OpeningTime
				1234 // Seed
		);*/
		
	
		System.out.println("Simuleringsexempel 2\n");
		StoreState s = new StoreState(
				2, // Cash registers
				7, // Max customers
				3.0, // Arrive Interval
				0.35, // CashierMin
				0.6, // CashierMax
				0.6, // PickingMin
				0.9, // PickingMax
				8, // OpeningTime
				13 // Seed
		);
		
		
		// View
		StoreSimulationViewer v = new StoreSimulationViewer(s);
		s.addObserver(v);
		v.startView();

		// Queue
		EventQueue e = new EventQueue();
		e.addToQueue(new StartEvent(e, s, 0));
		
		// Runs
		Simulator simulator = new Simulator(s, e);
		simulator.run();
		
		// Result
		v.resultsView();
		
	}

}
