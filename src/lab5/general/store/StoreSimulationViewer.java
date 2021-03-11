package lab5.general.store;

import java.util.Observable;
import lab5.general.View;

@SuppressWarnings("deprecation")
public class StoreSimulationViewer extends View {

	private StoreState s;

	/**
	 * 
	 * @param storeState
	 */
	public StoreSimulationViewer(StoreState storeState) {
		this.s = storeState;
	}

	/**
	 * 
	 */
	public void startView() {
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor, N..........: " + s.CASHREGISTERS);
		System.out.println("Max som ryms, M..........: " + s.MAXCUSTOMERS);
		System.out.println("Ankomshastighet, lambda..: " + s.ARRIVALINTERVAL);
		System.out.println("Plocktider, [P_min..Pmax]: [" + s.PICKINGMIN + ".." + s.PICKINGMAX + "]");
		System.out.println("Betaltider, [K_min..Kmax]: [" + s.CACHIERMIN + ".." + s.CACHIERMAX + "]");
		System.out.println("Frö, f...................: " + s.RANDOMIZERSEED);
		System.out.println();
		
		System.out.println("FÖRLOPP");
		System.out.println("=======");
		String columnNames = String.format("%s\t%9s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
				"Tid", "Händelse", "Kund", "?", "led", "ledT", "I", "$", ":-(", "köat", "köT", "köar", "[Kassakö..]");
		System.out.println(columnNames);
	}
	
	/**
	 * 
	 */
	public void resultsView() {
		// TODO printa något användbart
		//
		//System.out.println("RESULTAT \n========== \n" +
		//		"1) Av  kunder handlade 8 medan 2 missades."
		//		/*+ antalet som betalade*/ + "medan\n" /*+ antalet missade kunder (pga fullt i butik)*/);
		//
		//System.out.println("2) Total ledig kassatid: LäGG TILL SEN! \n" + "Genomsnitlig ledig kassatid: LäGG TILL te "
		//		+ "(dvs x% av tiden från öppning tills sista kunden betalat).");
		//
		//System.out.println("3) Total tid 5 kunder tvingats köa: LäGG TILL te. \n "
		//		+ "Genomsnitlig kötid: LäGG TILL te.");
	}

	/**
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg != "Start" && arg != "Stop") {
			String columnNames = String.format("%s\t%9s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
					s.currentTime, 
					arg, 
					"??", // Customer id
					s.isOpen ? 'Ö' : 'S', 
					s.freeCashRegisters,
					s.getTotalCashRegisterDowntime(), 
					s.currentCustomers, 
					s.getTotalCustomers(), 
					s.getTotalMissedCustomers(), 
					s.getTotalQueueCustomers(),
					s.getTotalQueueTime(), 
					s.getQueueLength(),
					s.getQueue());
			System.out.println(columnNames);
		} else {
			String columnNames = String.format("%s\t%9s",
					s.currentTime, 
					arg);
			System.out.println(columnNames);
		}
	}
}
