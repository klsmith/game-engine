package com.pkw.test.player;

public interface State {

	public State apply(Input input);

	public void step();
}
