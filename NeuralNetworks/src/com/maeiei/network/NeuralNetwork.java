package com.maeiei.network;

import com.maeiei.model.Matrix;
import com.maeiei.rule.Rule;

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
		network.run();
		output = network.getOutput();
	}

	public void fitting() {
		rule.amend();
	}

	public Matrix getOutput() {
		return output;
	}
	
	public void setNetwork(Network network) {
		this.network = network;
	}
}
