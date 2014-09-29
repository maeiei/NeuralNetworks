package com.maeiei;

import java.util.LinkedList;

public class MultiNetwork implements Network {

	private LinkedList<Level> levels;

	private Matrix input;

	private Matrix initResult;

	public MultiNetwork(Matrix input, Matrix initResult) {
		levels = new LinkedList<>();
		this.input = input;
		this.initResult = initResult;
	}

	@Override
	public void add(Level level) {
		levels.add(level);
	}

	@Override
	public void addFirst(Level inputLevel) {
		levels.addFirst(inputLevel);
	}

	@Override
	public void addLast(Level outputLevel) {
		add(outputLevel);
	}

	@Override
	public Matrix getOutput() {
		calculateOutput();
		return getLast().getOutput();
	}

	private void calculateOutput() {
		if (isSingelElement()) {
			singelElement();
		} else {
			multiElements();
		}
	}

	private void singelElement() {
		Level level = levels.get(0);
		level.setInput(input);
		level.setInitResult(initResult);
		level.setFirstHead(true);
		level.setLastLevel(true);
	}

	private void multiElements() {
		for (int i = 0, size = levels.size(); i < size; i++) {
			Level level = levels.get(i);
			if (i == 0) {
				changeFirstElement(i, level);
			} else if (i == size - 1) {
				changeLastElement(i, level);
			} else {
				changeNormalElement(i, level);
			}
		}
	}

	private void changeNormalElement(int i, Level level) {
		level.setInput(levels.get(i - 1).getOutput());
		levels.get(i + 1).setInput(level.getOutput());
		level.setFirstHead(false);
		level.setLastLevel(false);
	}

	private void changeLastElement(int i, Level level) {
		level.setInput(levels.get(i - 1).getOutput());
		level.setInitResult(initResult);
		level.setFirstHead(false);
		level.setLastLevel(true);
	}

	private void changeFirstElement(int i, Level level) {
		level.setInput(this.input);
		levels.get(i + 1).setInput(level.getOutput());
		level.setFirstHead(true);
		level.setLastLevel(false);
	}

	public boolean isSingelElement() {
		return levels.size() == 1;
	}

	@Override
	public LinkedList<Level> getLevels() {
		return levels;
	}

	@Override
	public Level getFirst() {
		return levels.getFirst();
	}

	@Override
	public Level getLast() {
		return levels.getLast();
	}

	public Matrix getInput() {
		return input;
	}

	public Matrix getInitResult() {
		return initResult;
	}

	public void setInput(Matrix input) {
		this.input = input;
	}

	public void setInitResult(Matrix initResult) {
		this.initResult = initResult;
	}
}
