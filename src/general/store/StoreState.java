package general.store;

import general.State;

public class StoreState extends State {
    int cashRegisters;
    int maxCustomers;
    // changed to double from int due to time being a double
    double arriveInterval;

    // changed from the uml doc
    double currentTime;

    // these are not specified in uml but are needed to operate the events
    public boolean isOpen;
    int currentCustomers;

}
