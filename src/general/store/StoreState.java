package general.store;

import general.State;

public class StoreState extends State {
    // Simulation parameters
    protected int cashRegisters;
    public int maxCustomers;
    protected double arriveInterval; // AKA Lambda?
    protected double cashierMin, cashierMax, pickingMin, pickingMax;
    protected int openingTime;
    public long randomizerSeed;

    // Results
    private int totalCustomers = 0;
    private int totalBuyers = 0;
    private int totalMissedBuyers = 0;
    private int totalCashRegisterDowntime = 0;
    private int totalQueueTime = 0;
    private int missedCustomers = 0;
    private int customersWhoHadToQueue = 0;

    // Other
    public CashRegisterQueue cQueue = new CashRegisterQueue();
    public CustomerCreator cCreator = new CustomerCreator();
    private int currentAmountCustomers = 0;
    public double currentTime;

    public boolean isOpen = true;
    public int currentCustomers = 0;

    public int freeCashRegisters = cashRegisters;

    public ArriveIntervalCalculator arrive;
    public CashierSpeedCalculator cashierSpeed;
    public PickingTimeCalculator pickingTime;
    public StoreState(int cashRegisters, int maxCustomers, double arriveInterval,
                      double cashierMin, double cashierMax, double pickingMin,
                      double pickingMax, int openingTime, int seed) {

        this.cashRegisters = cashRegisters;
        this.maxCustomers = maxCustomers;
        this.arriveInterval = arriveInterval;
        this.cashierMin = cashierMin;
        this.cashierMax = cashierMax;
        this.pickingMin = pickingMin;
        this.pickingMax = pickingMax;
        this.openingTime = openingTime;
        this.randomizerSeed = seed;
        this.setChanged();
        this.notifyObservers();
        arrive = new ArriveIntervalCalculator(arriveInterval, randomizerSeed);
        cashierSpeed = new CashierSpeedCalculator(cashierMin, cashierMax, randomizerSeed);
        pickingTime = new PickingTimeCalculator(pickingMin, pickingMax, randomizerSeed);

    }

    public Customer newCustomer() {
        sendUpdate();
        return cCreator.getCustomer();
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

    public void missedCustomer() {
        this.missedCustomers += 1;
    }

    public void sendUpdate() {
        setChanged();
        notifyObservers();
    }

    // Getters and setters
    public int getCashRegisters() {
        return cashRegisters;
    }

    public int getMaxCustomers() {
        return maxCustomers;
    }

    public String get_pMin() {
        return Double.toString(pickingMin);
    }

    public String get_pMax() {
        return Double.toString(pickingMax);
    }

    public String get_kMin() {
        return Double.toString(cashierMin);
    }

    public String get_kMax() {
        return Double.toString(cashierMax);
    }

    public double getLambda() {
        return arriveInterval;
    }

    public long getSeed() {
        return randomizerSeed;
    }

    // GETTERS/SETTERS FOR ROW BY ROW UPDATES

    // Getters and setters for results
    public int getTotalCustomers() {
        return totalCustomers;
    }

    public int getTotalBuyers() {
        return totalBuyers;
    }

    public int getTotalMissedBuyers() {
        return totalMissedBuyers;
    }

    public int getTotalCashRegisterDowntime() {
        return totalCashRegisterDowntime;
    }

    public int getTotalQueueTime() {
        return totalQueueTime;
    }

    public int getMissedCustomers() {
        return missedCustomers;
    }




}
