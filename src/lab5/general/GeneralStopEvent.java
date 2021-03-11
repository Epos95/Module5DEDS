package lab5.general;

public class GeneralStopEvent extends Event {
    private double time;
    private State state;

    public GeneralStopEvent(double t, State state) {
        this.time = t;
        this.state = state;
    }

    @Override
    public void execute() {
        state.currentTime = this.time;
        state.notifyObservers();
        state.isNotRunning = true;
    }
}
