package com.maeiei.network;

import com.maeiei.level.Level;
import com.maeiei.level.NullLevel;
import com.maeiei.model.Matrix;

public class MultiNetwork implements Network {

	private Level head;

	private Matrix input;

	private Matrix initResult;

	public MultiNetwork(Matrix input, Matrix initResult) {
		this(NullLevel.getNull(), input, initResult);
	}

	public MultiNetwork(Level head, Matrix input, Matrix initResult) {
		this.head = head;
		this.input = input;
		this.initResult = initResult;
	}

	public void add(Level level) {
		if (head.isNull()) {
			head = level;
			head.setInput(input);
			head.setInitResult(initResult);
		} else {
			Level node = head;
			while (node.hasNext()) {
				node = node.getNextLevel();
			}
			node.setNextLevel(level);
			level.setPreviousLevel(node);
			//level.setInput(node.getOutput());
			level.setInitResult(initResult);
		}
	}

	@Override
	public void run() {
		Level next = head;
		while (next.hasNext()) {
			next.getNextLevel().setInput(next.getOutput());
			next = next.getNextLevel();
		}
	}

	public Matrix getOutput() {
		return getLast().getOutput();
	}

	public Matrix getInput() {
		return input;
	}

	public Matrix getInitResult() {
		return initResult;
	}

	public void setInput(Matrix input) {
		this.input = input;
		head.setInput(input);
	}

	public void setInitResult(Matrix initResult) {
		this.initResult = initResult;
		getLast().setInitResult(initResult);
	}

	public Level getHead() {
		return head;
	}

	public Level getLast() {
		Level next = head;
		while (next.hasNext()) {
			next = next.getNextLevel();
		}
		return next;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		Level next = head;
		while (next.hasNext()) {
			sb.append("Level: ").append(next.toString()).append("\n");
			next = next.getNextLevel();
		}
		sb.append("Input: ").append(input.toString()).append("\n");
		sb.append("InitResult: ").append(initResult.toString()).append("\n");
		return sb.toString();
	}
}
