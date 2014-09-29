package com.maeiei;

import java.util.LinkedList;

public interface Network {

	public abstract void add(Level level);

	public abstract void addFirst(Level inputLevel);

	public abstract void addLast(Level outputLevel);

	public abstract boolean isSingelElement();

	public abstract Matrix getOutput();

	public abstract LinkedList<Level> getLevels();

	public abstract Level getFirst();

	public abstract Level getLast();
}