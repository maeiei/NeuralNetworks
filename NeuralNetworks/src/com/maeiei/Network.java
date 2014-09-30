package com.maeiei;

public interface Network {

	public Matrix getOutput();

	public void setInput(Matrix input);

	public void setInitResult(Matrix initResult);

	public void add(Level level);

	public Level getHead();

	public Level getLast();

	public void run();
}