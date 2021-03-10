package general.store;

import general.State;
import general.Event;

import java.util.Observable;

public class StoreState extends Observable {
    // Simulation parameters
    private final int cashRegisters = 4;
    private final int maxCustomers = 50;
    private final double arriveInterval = 1; // num of customers an "hour"
    private final double cashierMin = 2;
    private final double cashierMax = 4;
    private final double pickingMin = 1;
    private final double pickingMax = 5;
    private final int openingTime = 0;
    public final int randomizerSeed = 1234;

    // Results
    private int buyers;
    private int missedBuyers;
    private int cashRegisterDowntime;
    private int queueTime;

    // Other
//    private CashRegisterQueue cQueue = new CashRegisterQueue();
//    private CustomerCreator cCreator = new CustomerCreator();
//    private int currentAmountCustomers = 0;
    double currentTime;

    public boolean isOpen;
    int currentCustomers;

    private int freeCashRegisters = cashRegisters;
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
