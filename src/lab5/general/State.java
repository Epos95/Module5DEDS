package lab5.general;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class State extends Observable{
	
	public boolean isNotRunning = false;
	public double currentTime;
}
