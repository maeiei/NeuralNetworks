package com.maeiei;

import java.util.LinkedList;

public class MultiNetwork implements Network {

	private LinkedList<Level> levels;

	private Matrix input;

	private Matrix initResult;

	public MultiNetwork(Matrix input, Matrix initResult) {
		this.input = input;
		this.initResult = initResult;
	}

	@Override
	public void add(Level level) {
		levels.add(level);
		multiElements();
	}

	@Override
	public void addFirst(Level inputLevel) {
		levels.addFirst(inputLevel);
		multiElements();
	}

	@Override
	public void addLast(Level outputLevel) {
		levels.add(outputLevel);
		multiElements();
	}
	private void multiElements() {
		for (int i = 0, size = levels.size(); i < size; i++) {
			Level level = levels.get(i);
			if (i == 0) {
				changeFirstElement(i, level);
			} else if (i == size - 1) {
				changeLastElement(i, level);
			} else {
				changeDormalElement(i, level);
			}
		}
	}

	private void changeDormalElement(int i, Level level) {
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

	@Override
	public boolean isSingelElement() {
		return false;
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

	@Override
	public Matrix getOutput() {
		return getLast().getOutput();
	}
}
