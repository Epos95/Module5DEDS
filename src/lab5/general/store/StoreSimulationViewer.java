package lab5.general.store;

import java.util.Observable;
import lab5.general.View;

/**
 * <p>
 * The view of the store simulation. Shows the steps of the simulation.
 * </p>
 * 
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and Max
 *         Agnesund
 */
@SuppressWarnings("deprecation")
public class StoreSimulationViewer extends View {

	private StoreState s;

	/**
	 * @param storeState The storeState
	 */
	public StoreSimulationViewer(StoreState storeState) {
		this.s = storeState;
	}

	/**
	 * Prints the parameters of the simulation
	 */
	public void startView() {
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor, N..........: " + s.CASHREGISTERS);
		System.out.println("Max som ryms, M..........: " + s.MAXCUSTOMERS);
		System.out.println("Ankomshastighet, lambda..: " + s.ARRIVALINTERVAL);
		System.out.println("Plocktider, [P_min..Pmax]: [" + s.PICKINGMIN + ".."
		+ s.PICKINGMAX + "]");
		System.out.println("Betaltider, [K_min..Kmax]: [" + s.CACHIERMIN + ".."
		+ s.CACHIERMAX + "]");
		System.out.println("Frö, f...................: " + s.RANDOMIZERSEED);
		System.out.println();

		System.out.println("FÖRLOPP");
		System.out.println("=======");
		String columnNames = String.format("%s\t%9s\t%s\t%s\t%s\t%s\t%s\t%s\t%s"
				+ "\t%s\t%s\t%s\t%s", "Tid", "Händelse",
				"Kund", "?", "led", "ledT", "I", "$", ":-(", "köat", "köT",
				"köar", "[Kassakö..]");
		System.out.println(columnNames);
	}

	/**
	 * Prints the results of the simulation.
	 */
	public void resultsView() {

		System.out.println();
		System.out.println("RESULTAT");
		System.out.println("==========");
		System.out.println();
		System.out.println(String.format("1) Av %s kunder handlade %s medan %s"
				+ " missades.",
				s.getTotalMissedCustomers() + s.getTotalCustomers(),
				s.getTotalCustomers(),
				s.getTotalMissedCustomers()));
		System.out.println();
		System.out.println(String.format("2) Total tid %s kassor varit lediga:"
				+ " %.2f te.", s.CASHREGISTERS,
				s.getTotalCashRegisterDowntime()));
		System.out.println(String.format("Genomsnitlig ledig kassatid: %.2f te",
				s.getTotalCashRegisterDowntime() / s.CASHREGISTERS));
		System.out.println(String.format("(dvs %.2f%% av tiden från öppning "
				+ "tills sista kunden betalat).",
				(s.getTotalCashRegisterDowntime() / s.CASHREGISTERS /
						s.getStoreActualCloseTime()) * 100));
		System.out.println();
		System.out.println(String.format("3) Total tid %s kunder tvingats köa:"
				+ " %.2f te.", s.getTotalQueueCustomers(),
				s.getTotalQueueTime()));
		System.out.println(
				String.format("Genomsnitlig kötid: %.2f te.",
						s.getTotalQueueTime() / s.getTotalQueueCustomers()));
	}

	/**
	 * Prints every event occuring during the simulation.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (((String[]) arg)[0] != "Start" && ((String[]) arg)[0] != "Stop") {
			String columnNames = String.format("%.2f\t%9s\t%s\t%s\t%d\t%.2f\t%d"
					+ "\t%d\t%d\t%d\t%.2f\t%d\t%s",
					s.currentTime, ((String[]) arg)[0], ((String[]) arg)[1],
					s.isOpen ? 'Ö' : 'S', s.freeCashRegisters,
					s.getTotalCashRegisterDowntime(), s.currentCustomers,
					s.getTotalCustomers(),
					s.getTotalMissedCustomers(), s.getTotalQueueCustomers(),
					s.getTotalQueueTime(), s.getQueueLength(),
					s.getQueue());
			System.out.println(columnNames);
		} else {
			String columnNames = String.format("%.2f\t%9s", s.currentTime,
					((String[]) arg)[0]);
			System.out.println(columnNames);
		}
	}
}
