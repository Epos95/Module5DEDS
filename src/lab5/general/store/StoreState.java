package lab5.general.store;

import lab5.general.State;

@SuppressWarnings("deprecation")
public class StoreState extends State {
	
    // Simulation parameters
    public final int CASHREGISTERS;
    public final int MAXCUSTOMERS;
    public final double ARRIVALINTERVAL;
    public final double CACHIERMIN, CACHIERMAX, PICKINGMIN, PICKINGMAX;
    public final double OPENINGTIME;
    public final long RANDOMIZERSEED;

    // Results
    private int totalCustomers = 0;
    private int totalMissedCustomers = 0;
    private int totalCashRegisterDowntime = 0;
    private int totalQueueTime = 0;

    // Other
    public CashRegisterQueue cQueue = new CashRegisterQueue();
    public CustomerCreator cCreator = new CustomerCreator();
    public boolean isOpen;
    public int currentCustomers;
    public int freeCashRegisters;

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

    	//
        this.CASHREGISTERS = cashRegisters;
        this.MAXCUSTOMERS = maxCustomers;
        this.ARRIVALINTERVAL = arriveInterval;
        this.CACHIERMIN = cashierMin;
        this.CACHIERMAX = cashierMax;
        this.PICKINGMIN = pickingMin;
        this.PICKINGMAX = pickingMax;
        this.OPENINGTIME = openingTime;
        this.RANDOMIZERSEED = seed;
        
        //
        this.currentCustomers = 0;
        this.freeCashRegisters = CASHREGISTERS;
        
        //
        this.setChanged();
        this.notifyObservers();
        
        //
        arrive = new ArriveIntervalCalculator(arriveInterval, RANDOMIZERSEED);
        cashierSpeed = new CashierSpeedCalculator(cashierMin, cashierMax, RANDOMIZERSEED);
        pickingTime = new PickingTimeCalculator(pickingMin, pickingMax, RANDOMIZERSEED);

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
    }

    /**
     * 
     */
    public void openRegister() {
        if (freeCashRegisters < CASHREGISTERS) {
            freeCashRegisters++;
        }
    }

    /**
     * 
     */
	public void sendUpdate() {
        setChanged();
        notifyObservers();
    }
	
	// UPDATES FOR RESULT
    public void missedCustomer() {
        this.totalMissedCustomers += 1;
    }
    public void paidCustomer() {
    	this.totalCustomers += 1;
    }
	public void updateTime(double t) {
    	double timeDelta = t - currentTime;
    	currentTime = t;
    	
    	totalCashRegisterDowntime += timeDelta * freeCashRegisters;
    	totalQueueTime += timeDelta * this.cQueue.customerQueue.size();
	}

	// GETTERS FOR ROW BY ROW UPDATES
    public int getTotalCustomers() {
        return totalCustomers;
    }
    public int getTotalMissedBuyers() {
        return totalMissedCustomers;
    }
    public int getTotalCashRegisterDowntime() {
        return totalCashRegisterDowntime;
    }
    public int getTotalQueueTime() {
        return totalQueueTime;
    }
}
