package com.maeiei;

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
		rule.amend();
	}

	public Matrix getOutput() {
		return output;
	}
}
