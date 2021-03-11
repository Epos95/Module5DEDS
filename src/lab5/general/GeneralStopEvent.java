package lab5.general;

/**
 * <p>
 * Event to stop the simulation.
 * </p>
 *@author Anton Lundmark, Elliot Johansson Fryklöf, Karolina Rucinska and 
*Max Agnesund.
 */
public class GeneralStopEvent extends Event {
    private double time;
    private State state;
/**
* <p>
* Constructor for GeneralStopEvent.
* </p>
* @param t Time of event occurence.
* @param state The state.
*/
    public GeneralStopEvent(double t, State state) {
        this.time = t;
        this.state = state;
    }

/**
* <p>
* Stops the simulation.
* </p>
*/
    public void execute() {
        state.currentTime = this.time;
        state.notifyObservers();
        state.isNotRunning = true;
    }
}
