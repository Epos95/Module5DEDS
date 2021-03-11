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
    private double totalCashRegisterDowntime = 0;
    private double totalQueueTime = 0;
    private int totalQueueCustomers = 0;

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
     */
    public void sendUpdate(String eventString) {
        sendUpdate(eventString, "---");
    }
	public void sendUpdate(String eventString, String customerId) {
        setChanged();
        notifyObservers(new String[]{ eventString, customerId });
    }
    
    /**
     * 
     * @return
     */
    public Customer newCustomer() {
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
	
	// UPDATES FOR RESULT
    public void missedCustomer() {
        this.totalMissedCustomers += 1;
    }
    public void paidCustomer() {
    	this.totalCustomers += 1;
    }
    public void queuedCustomer() {
    	this.totalQueueCustomers += 1;
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
    public int getTotalMissedCustomers() {
        return totalMissedCustomers;
    }
    public double getTotalCashRegisterDowntime() {
        return totalCashRegisterDowntime;
    }
    public double getTotalQueueTime() {
        return totalQueueTime;
    }
    public int getTotalQueueCustomers() {
    	return totalQueueCustomers;
    }
    public int getQueueLength() {
    	return cQueue.customerQueue.size();
    }
    public String getQueue() {
    	return cQueue.toString();
    }
}
