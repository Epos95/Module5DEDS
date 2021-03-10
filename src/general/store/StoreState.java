package general.store;

import general.State;

import java.util.Observable;

public class StoreState extends Observable {
    int cashRegisters;
    protected int maxCustomers;
    // changed to double from int due to time being a double
    protected double arriveInterval;

    // changed from the uml doc
    protected double currentTime;

    // these are not specified in uml but are needed to operate the events
    public boolean isOpen;
    protected int currentCustomers;

}
