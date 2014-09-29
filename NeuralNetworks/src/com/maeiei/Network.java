package com.maeiei;

import java.util.LinkedList;

public interface Network {

	public abstract void add(Level level);

	public abstract void addFirst(Level inputLevel);

	public abstract void addLast(Level outputLevel);

	public abstract LinkedList<Level> getLevels();

	public abstract Level getFirst();

	public abstract Level getLast();

	public abstract Matrix getInput();

	public abstract Matrix getInitResult();

	public abstract Matrix getOutput();

	public abstract void setInput(Matrix input);

	public abstract void setInitResult(Matrix initResult);
}