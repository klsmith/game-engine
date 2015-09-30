package com.pkw.game;

public interface Game {
	public void run();

	public boolean isRunning();
	
	public void stop();

	public void onStart();

	public void onEnd();
}
