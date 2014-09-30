package com.maeiei.test;

import org.junit.Test;
import com.maeiei.BackPropagationRule;
import com.maeiei.Level;
import com.maeiei.Logsig;
import com.maeiei.Matrix;
import com.maeiei.MultiNetwork;
import com.maeiei.Network;
import com.maeiei.NeuralNetwork;
import com.maeiei.Purelin;

public class NeuralNetworkTest {

	@Test	
	public void testBackPropagationRule() {
		NeuralNetwork neuralNetwork = initNeuralNetwork();
		neuralNetwork.run();
		System.out.println(neuralNetwork.getOutput());
	}

	@Test
	public void testBackPropagationRuleCirculation() {
		Network network = initNetwork();
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		for (int i = 0; i < 1; i++) {
			neuralNetwork.run();
		}
		System.out.println(neuralNetwork.getOutput());
		Matrix input = Matrix.unit(1, 1.0d);
		Matrix initResult = Matrix.unit(1, 1.707d);
		network.setInput(input);
		network.setInitResult(initResult);
		neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		for (int i = 0; i < 1; i++) {
			neuralNetwork.run();
		}
		System.out.println(neuralNetwork.getOutput());
		input = Matrix.unit(1, 2.0d);
		initResult = Matrix.unit(1, 2.0d);
		network.setInput(input);
		network.setInitResult(initResult);
		neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		for (int i = 0; i < 1; i++) {
			neuralNetwork.forword();
		}
		System.out.println(neuralNetwork.getOutput());
	}

	private Level initFirstLevel() {
		double[][] weightData = { { -0.27 }, { -0.41 } };
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(weight, bias, logsig);
		return level;
	}

	private Level initSecondLevel() {
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Level secondLevel = new Level(weightSecond, biasSecond, new Purelin());
		return secondLevel;
	}

	private Network initNetwork() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		double[][] inputData = { { 0 } };
		double[][] initResultData = { { 1 } };
		Matrix input = new Matrix(inputData);
		Matrix initResult = new Matrix(initResultData);
		Network network = new MultiNetwork(input, initResult);
		network.add(first);
		network.add(last);
		return network;
	}

	private NeuralNetwork initNeuralNetwork() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		double[][] inputData = { { 0 } };
		double[][] initResultData = { { 1 } };
		Matrix input = new Matrix(inputData);
		Matrix initResult = new Matrix(initResultData);
		Network network = new MultiNetwork(input, initResult);
		network.add(first);
		network.add(last);
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(last));
		return neuralNetwork;
	}
}
