package lab5.general;

import java.util.Observable;
import java.util.Observer;

import lab5.general.store.StoreState;

public class State extends Observable{
	public boolean isNotRunning = false;
	public double currentTime;


}
