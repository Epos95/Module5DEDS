package general.store;

import java.util.Observable;

import general.View;

public class StoreSimulatorViewer extends View {

	public void startView() {
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor: " /*+ antal kassor*/);
		System.out.println("Max som ryms: " /* + max som ryms*/);
		System.out.println("Ankomsthastighet: " /* + ankomsthastigheten*/);
		System.out.println("Plocktider: ");
		System.out.println("Betaltider: ");
		System.out.println("Fr�: ");
		System.out.println("");
		
		System.out.println("F�RLOPP");
		System.out.println("==========");
		System.out.println("Tid H�ndelse Kund ? led ledT I $ :-( k�at k�T k�ar [Kassak�..]\r\n"
				+ "");
	}
	
	public void resultsView() {
		
		System.out.println("RESULTAT \n========== \n1) Av " /*+ totalt skapade kunder*/ + "kunder handlade "
				/*+ antalet som betalade*/ + "medan\n" /*+ antalet missade kunder (pga fullt i butik)*/);
		
		System.out.println("2) Total ledig kassatid: L�GG TILL SEN! \n" + "Genomsnitlig ledig kassatid: L�GG TILL te "
				+ "(dvs x% av tiden fr�n �ppning tills sista kunden betalat).");
		
		System.out.println("3) Total tid 5 kunder tvingats k�a: L�GG TILL te. \n "
				+ "Genomsnitlig k�tid: L�GG TILL te.");
	}
	
	
	public void update(Observable o, Object arg) {
		
		System.out.println("L�ggs till senare!");
		
	}

}
