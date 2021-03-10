package general.store;

import general.State;
import general.GeneralEvent;

import java.util.Observable;

public class StoreState extends Observable {
    // Simulation parameters
    protected final int cashRegisters = 4;
    protected final int maxCustomers = 50;
    protected final double arriveInterval = 1; // num of customers an "hour"
    protected final double cashierMin = 2;
    protected final double cashierMax = 4;
    protected final double pickingMin = 1;
    protected final double pickingMax = 5;
    protected final int openingTime = 0;
    public final int randomizerSeed = 1234;

    // Results
    private int buyers;
    private int missedBuyers;
    private int cashRegisterDowntime;
    private int queueTime;

    // Other
    protected CashRegisterQueue cQueue = new CashRegisterQueue();
    private CustomerCreator cCreator = new CustomerCreator();
    private int currentAmountCustomers = 0;
    double currentTime;

    public boolean isOpen;
    protected int currentCustomers;

    protected int freeCashRegisters = cashRegisters;
    CustomerCreator customerCreator;

    public StoreState() {
        ArriveIntervalCalculator arrive = new ArriveIntervalCalculator(arriveInterval, randomizerSeed);
        CashierSpeedCalculator cashierSpeed = new CashierSpeedCalculator(cashierMin, cashierMax, randomizerSeed);
        PickingTimeCalculator pickingTime = new PickingTimeCalculator(pickingMin, pickingMax, randomizerSeed);


        System.out.println(arrive.getTime());
        System.out.println(cashierSpeed.getTime());
        System.out.println(pickingTime.getTime());

        customerCreator = new CustomerCreator();
    }

    public Customer newCustomer() {
        return customerCreator.getCustomer();
    }

    public void closeRegister() {
        if (freeCashRegisters > 0) {
            freeCashRegisters--;
        }
        else {
            // Throw error eller nåt?
        }
    }

    public void openRegister() {
        if (freeCashRegisters < cashRegisters) {
            freeCashRegisters++;
        }
        else {
            // Throw error eller nåt?
        }
    }

}
