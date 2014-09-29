package com.maeiei;

import java.util.LinkedList;
import java.util.ListIterator;

public class NeuralNetwork {

	private LinkedList<Level> levels;

	private Rule rule;

	private Matrix input;

	private Matrix initResult;

	private Matrix output;

	public NeuralNetwork(Rule rule, Matrix input, Matrix initResult) {
		levels = new LinkedList<>();
		this.rule = rule;
		this.input = input;
		this.initResult = initResult;
	}

	public void run() {
		forword();
		fitting();
	}

	public void forword() {
		output = getLast().getOutput();
	}

	public void fitting() {
		LinkedList<Level> reversedLevels = reverse();
		for (ListIterator<Level> iterator = reversedLevels.listIterator(); iterator.hasNext();) {
			Level level = iterator.next();
			if (level.isLastLevel()) {
				rule = new BackPropagationRule(level);
			} else {
				iterator.previous();
				rule = new BackPropagationRule(level, iterator.previous());
				iterator.next();
				iterator.next();
			}
			rule.amend();
		}
	}

	private LinkedList<Level> reverse() {
		LinkedList<Level> copiedLevels = new LinkedList<>();
		for (Level level : levels) {
			copiedLevels.addFirst(level);
		}
		return copiedLevels;
	}

	public void add(Level level) {
		levels.add(level);
		traverse();
	}

	public void addFirst(Level inputLevel) {
		levels.addFirst(inputLevel);
		traverse();
	}

	public void addLast(Level outputLevel) {
		levels.addLast(outputLevel);
		traverse();
	}

	private void traverse() {
		if (isSingelElement()) {
			singelElement();
		} else {
			multiElements();
		}
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

	private boolean isSingelElement() {
		return levels.size() == 1;
	}

	private void singelElement() {
		Level level = levels.get(0);
		level.setInput(this.input);
		level.setInitResult(initResult);
		level.setFirstHead(true);
		level.setLastLevel(true);
	}

	public Level getFirst() {
		return levels.getFirst();
	}

	public Level getLast() {
		return levels.getLast();
	}

	public Matrix getOutput() {
		return output;
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
}
