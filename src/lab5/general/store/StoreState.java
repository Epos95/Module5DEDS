package lab5.general.store;

import lab5.general.State;

@SuppressWarnings("deprecation")
public class StoreState extends State {
	
    // Simulation parameters
    protected int cashRegisters;
    public int maxCustomers;
    protected double arriveInterval;
    protected double cashierMin, cashierMax, pickingMin, pickingMax;
    public double openingTime;
    public long randomizerSeed;

    // Results
    private int totalCustomers = 0;
    private int totalBuyers = 0;
    private int totalMissedBuyers = 0;
    private int totalCashRegisterDowntime = 0;
    private int totalQueueTime = 0;
    private int missedCustomers = 0;

    // Other
    public CashRegisterQueue cQueue = new CashRegisterQueue();
    public CustomerCreator cCreator = new CustomerCreator();
    public boolean isOpen = true;
    public int currentCustomers = 0;
    public int freeCashRegisters = cashRegisters;

    // Calculators
    public ArriveIntervalCalculator arrive;
    public CashierSpeedCalculator cashierSpeed;
    public PickingTimeCalculator pickingTime;
    
    /**
     * 
     * @param cashRegisters
     * @param maxCustomers
     * @param arriveInterval
     * @param cashierMin
     * @param cashierMax
     * @param pickingMin
     * @param pickingMax
     * @param openingTime
     * @param seed
     */
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

    /**
     * 
     * @return
     */
    public Customer newCustomer() {
        sendUpdate();
        return cCreator.getCustomer();
    }

    /**
     * 
     */
    public void closeRegister() {
        if (freeCashRegisters > 0) {
            freeCashRegisters--;
        }
        else {
            // Throw error eller nåt?
        }
    }

    /**
     * 
     */
    public void openRegister() {
        if (freeCashRegisters < cashRegisters) {
            freeCashRegisters++;
        }
        else {
            // Throw error eller nåt?
        }
    }

    /**
     * 
     */
    public void missedCustomer() {
        this.missedCustomers += 1;
    }

    /**
     * 
     */
	public void sendUpdate() {
        setChanged();
        notifyObservers();
    }

	// GETTERS/SETTERS FOR ROW BY ROW UPDATES
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
