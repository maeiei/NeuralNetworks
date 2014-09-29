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

	public void addFirst(Level inputLevel) {
		inputLevel.setInput(this.input);
		levels.addFirst(inputLevel);
	}

	public void addLast(Level outputLevel) {
		outputLevel.setInput(getFirst().getOutput());
		outputLevel.setInitResult(initResult);
		levels.addLast(outputLevel);
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
}
