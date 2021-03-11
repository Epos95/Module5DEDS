package general.store;

import java.util.Observable;
import java.util.Observer;

import general.View;

public class StoreSimulatorViewer extends View {

	private StoreState s;

	public StoreSimulatorViewer(StoreState storeState) {
		this.s = storeState;
	}

	public void startView() {
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor, N..........: " + s.getCashRegisters());
		System.out.println("Max som ryms, M..........: " + s.getMaxCustomers());
		System.out.println("Ankomshastighet, lambda..: " + s.getLambda());
		System.out.println("Plocktider, [P_min..Pmax]: [" + s.get_pMin() + ".." + s.get_pMax() + "]");
		System.out.println("Betaltider, [K_min..Kmax]: [" + s.get_kMin() + ".." + s.get_kMax() + "]");
		System.out.println("Frö, f...................: " + s.getSeed());
		System.out.println("");
		
		System.out.println("FÖRLOPP");
		System.out.println("=======");
		String columnNames = String.format("%s\t%9s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
				"Tid", "Händelse", "Kund", "?", "led", "ledT", "I", "$", ":-(", "köat", "köT", "köar", "[Kassakö..]");
		System.out.println(columnNames);
	}
	
	public void resultsView() {
		// TODO printa något användbart
		
		System.out.println("RESULTAT \n========== \n" +
				"1) Av  kunder handlade 8 medan 2 missades."
				/*+ antalet som betalade*/ + "medan\n" /*+ antalet missade kunder (pga fullt i butik)*/);
		
		System.out.println("2) Total ledig kassatid: LäGG TILL SEN! \n" + "Genomsnitlig ledig kassatid: LäGG TILL te "
				+ "(dvs x% av tiden från öppning tills sista kunden betalat).");
		
		System.out.println("3) Total tid 5 kunder tvingats köa: LäGG TILL te. \n "
				+ "Genomsnitlig kötid: LäGG TILL te.");
	}

	public void update(Observable o, Object arg) {
	    System.out.println("got updated!");
		// TODO kör olika prints beroende på vilket currentState som storeState har.
		// ex) Parameter texten vid StartEvent
		// ex) Resultat texten vid StopEvent

	}

}
