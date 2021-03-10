package general.store;

import java.util.Observable;
import java.util.Observer;

import general.View;

public class StoreSimulatorViewer extends View implements Observer {

	public void startView() {
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor: " /*+ antal kassor*/);
		System.out.println("Max som ryms: " /* + max som ryms*/);
		System.out.println("Ankomsthastighet: " /* + ankomsthastigheten*/);
		System.out.println("Plocktider: ");
		System.out.println("Betaltider: ");
		System.out.println("Frö: ");
		System.out.println("");
		
		System.out.println("FöRLOPP");
		System.out.println("==========");
		System.out.println("Tid Höndelse Kund ? led ledT I $ :-( köat köT köar [Kassakö..]\r\n"
				+ "");
	}
	
	public void resultsView() {
		
		System.out.println("RESULTAT \n========== \n1) Av " /*+ totalt skapade kunder*/ + "kunder handlade "
				/*+ antalet som betalade*/ + "medan\n" /*+ antalet missade kunder (pga fullt i butik)*/);
		
		System.out.println("2) Total ledig kassatid: LäGG TILL SEN! \n" + "Genomsnitlig ledig kassatid: LäGG TILL te "
				+ "(dvs x% av tiden från öppning tills sista kunden betalat).");
		
		System.out.println("3) Total tid 5 kunder tvingats köa: LäGG TILL te. \n "
				+ "Genomsnitlig kötid: LäGG TILL te.");
	}
	

	@Override
	public void update(Observable o, Object arg) {
	    System.out.println("got updated!");

	}

}
