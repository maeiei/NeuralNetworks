package com.maeiei.network;

import java.util.ArrayList;
import java.util.List;
import com.maeiei.model.Matrix;
import com.maeiei.rule.Rule;

public class NeuralNetwork {

	private Network network;

	private Rule rule;

	private Matrix output;

	private List<Matrix> inputs;

	private List<Matrix> initResults;

	public NeuralNetwork(Network network, Rule rule) {
		this(network, rule, new ArrayList<Matrix>(), new ArrayList<Matrix>());
	}

	public NeuralNetwork(Network network, Rule rule, List<Matrix> inputs, List<Matrix> initResults) {
		this.network = network;
		this.rule = rule;
		this.inputs = inputs;
		this.initResults = initResults;
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

	public List<Matrix> getInputs() {
		return inputs;
	}

	public void setInputs(List<Matrix> inputs) {
		this.inputs = inputs;
	}

	public List<Matrix> getInitResults() {
		return initResults;
	}

	public void setInitResults(List<Matrix> initResults) {
		this.initResults = initResults;
	}
}
