package com.maeiei.network;

import java.util.ArrayList;
import java.util.List;
import com.maeiei.model.Data;
import com.maeiei.model.Matrix;
import com.maeiei.rule.Rule;

public class NeuralNetwork {

	private Network network;

	private Rule rule;

	private Matrix output;

	private List<Data> inputs;

	private List<Data> initResults;

	public NeuralNetwork(Network network, Rule rule) {
		this(network, rule, new ArrayList<Data>(), new ArrayList<Data>());
	}

	public NeuralNetwork(Network network, Rule rule, List<Data> inputs, List<Data> initResults) {
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

	public List<Data> getInputs() {
		return inputs;
	}

	public void setInputs(List<Data> inputs) {
		this.inputs = inputs;
	}

	public List<Data> getInitResults() {
		return initResults;
	}

	public void setInitResults(List<Data> initResults) {
		this.initResults = initResults;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("network: ").append(network.toString()).append("\n");
		sb.append("output: ").append(output.toString()).append("\n");
		return sb.toString();
	}
}
