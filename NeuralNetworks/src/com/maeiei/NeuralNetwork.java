package com.maeiei;

import java.util.LinkedList;
import java.util.ListIterator;

public class NeuralNetwork {

	private Network network;

	private Rule rule;

	private Matrix output;

	public NeuralNetwork(Network network, Rule rule) {
		this.network = network;
		this.rule = rule;
	}

	public void run() {
		forword();
		fitting();
	}

	public void forword() {
		output = network.getOutput();
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
		for (Level level : network.getLevels()) {
			copiedLevels.addFirst(level);
		}
		return copiedLevels;
	}

	public Level getLast() {
		return network.getLevels().getLast();
	}

	public Matrix getOutput() {
		return output;
	}
}
