package lab5.general.store;

import lab5.general.State;

/**
 * <p>
 * Stores all variables of the simulation.
 * </p>
 * @author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
 * Max Agnesund
 */

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
    private double storeActualCloseTime = 0;
    
    // Other
    public CashRegisterQueue cQueue = new CashRegisterQueue();
    public CustomerCreator cCreator = new CustomerCreator();
    public boolean isOpen;
    public boolean isRunning;
    public int currentCustomers;
    public int freeCashRegisters;

    // Calculators
    public ArriveIntervalCalculator arrive;
    public CashierSpeedCalculator cashierSpeed;
    public PickingTimeCalculator pickingTime;
    
    /**
     * 
     * @param cashRegisters Amount of cashregisters in use during simulation.
     * @param maxCustomers Max amount of customers allowed in store.
     * @param arriveInterval Interval for when customers arrive.
     * @param cashierMin Minimum time for checkouts.
     * @param cashierMax Maximum time for checkouts.
     * @param pickingMin Minium time for picking.
     * @param pickingMax Maximum time for picking.
     * @param openingTime Time when the store opens.
     * @param seed The seed of the simulation.
     */
    public StoreState(int cashRegisters, int maxCustomers, double arriveInterval,
                      double cashierMin, double cashierMax, double pickingMin,
                      double pickingMax, double openingTime, int seed) {

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
     * Notifies View class of an update. 
     */
    public void sendUpdate(String eventString) {
        sendUpdate(eventString, "---");
    }
	public void sendUpdate(String eventString, String customerId) {
        setChanged();
        notifyObservers(new String[]{ eventString, customerId });
    }
    
    /**
     * Creates new customer.
     * @return A new customer.
     */
    public Customer newCustomer() {
        return cCreator.getCustomer();
    }

    /**
     * Closes a cahs register.
     */
    public void closeRegister() {
        if (freeCashRegisters > 0) {
            freeCashRegisters--;
        }
    }

    /**
     * Opens a chash register.
     */
    public void openRegister() {
        if (freeCashRegisters < CASHREGISTERS) {
            freeCashRegisters++;
        }
    }
    

    /**
     * Closes the store.
     */
    public void closeStore() {
    	isRunning = false;
    	storeActualCloseTime = currentTime;
    }
	
    /**
     * Increases missed customers by 1.
     */
    public void missedCustomer() {
        this.totalMissedCustomers += 1;
    }

    /**
     * Increases paid customers by 1.
     */
    public void paidCustomer() {
    	this.totalCustomers += 1;
    }

    /**
     * Increases customers having had to queue by 1.
     */
    public void queuedCustomer() {
    	this.totalQueueCustomers += 1;
    }

    /**
     * Updates the time.
     */
	public void updateTime(double t) {
    	double timeDelta = t - currentTime;
    	currentTime = t;
    	
    	if (isRunning) {
    		totalQueueTime += timeDelta * this.cQueue.customerQueue.size();
    		totalCashRegisterDowntime += timeDelta * freeCashRegisters;
    	}
	}

    /**
     * Getter for total customers of the store.
     * @return Total customers.
     */
	// GETTERS FOR ROW BY ROW UPDATES
    public int getTotalCustomers() {
        return totalCustomers;
    }

    /**
     * Getter for missed customers.
     * @return Total missed customers.
     */
    public int getTotalMissedCustomers() {
        return totalMissedCustomers;
    }

    /**
     * Getter for total chash register downtime.
     * @return Total chash register downtime.
     */
    public double getTotalCashRegisterDowntime() {
        return totalCashRegisterDowntime;
    }

    /**
     * Getter for total time customers have had to queue.
     * @return Total time customers have had to queue for.
     */
    public double getTotalQueueTime() {
        return totalQueueTime;
    }

    /**
     * Getter for total amount of customers that had to queue.
     * @return Total cusotmers who had to queue.
     */
    public int getTotalQueueCustomers() {
    	return totalQueueCustomers;
    }

    /**
     * Getter for the customer queue length.
     * @return The lenght of the customer queue.
     */
    public int getQueueLength() {
    	return cQueue.customerQueue.size();
    }

    /**
     * Getter for the customer queue.
     * @return The customer queue.
     */
    public String getQueue() {
    	return cQueue.toString();
    }

    /**
     * Getter for the closing time of the store.
     * @return The closing time of the store.
     */
    public double getStoreActualCloseTime() {
    	return storeActualCloseTime;
    }
}
