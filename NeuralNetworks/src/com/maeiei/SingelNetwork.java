package com.maeiei;

import java.util.LinkedList;

public class SingelNetwork implements Network {

	private Level level;

	private Matrix input;

	private Matrix initResult;

	public SingelNetwork(Matrix input, Matrix initResult) {
		this.input = input;
		this.initResult = initResult;
	}

	@Override
	public void add(Level level) {
		this.level = level;
		level.setInput(this.input);
		level.setInitResult(initResult);
		level.setFirstHead(true);
		level.setLastLevel(true);
	}

	@Override
	public void addFirst(Level inputLevel) {
		add(inputLevel);
	}

	@Override
	public void addLast(Level outputLevel) {
		add(outputLevel);
	}

	public boolean isSingelElement() {
		return true;
	}

	@Override
	public LinkedList<Level> getLevels() {
		LinkedList<Level> levels = new LinkedList<Level>();
		levels.add(level);
		return levels;
	}

	public Matrix getInput() {
		return input;
	}

	public void setInput(Matrix input) {
		this.input = input;
	}

	public Matrix getInitResult() {
		return initResult;
	}

	public void setInitResult(Matrix initResult) {
		this.initResult = initResult;
	}

	@Override
	public Level getFirst() {
		return level;
	}

	@Override
	public Level getLast() {
		return level;
	}

	@Override
	public Matrix getOutput() {
		return null;
	}
}
