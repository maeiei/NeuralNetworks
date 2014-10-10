package com.maeiei.network;

import com.maeiei.level.Level;
import com.maeiei.model.Matrix;

public interface Network {

	public Matrix getOutput();

	public void setInput(Matrix input);

	public void setInitResult(Matrix initResult);

	public void add(Level level);

	public Level getHead();

	public Level getLast();

	public void run();
}