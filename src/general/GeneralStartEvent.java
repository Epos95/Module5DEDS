package general;

public abstract class GeneralStartEvent {
    protected EventQueue queue;
    protected double occurenceTime;

    abstract public void execute(State state);
    abstract public double getTime();
}
