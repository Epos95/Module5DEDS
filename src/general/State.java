package general;

import general.store.StoreState;

import java.util.Observable;
import java.util.Observer;

public class State extends Observable{
	public boolean isNotRunning = true;
	public double currentTime;


}
