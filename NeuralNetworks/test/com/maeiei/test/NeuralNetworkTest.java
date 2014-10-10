package com.maeiei.test;

import org.junit.Ignore;
import org.junit.Test;
import com.maeiei.function.Logsig;
import com.maeiei.function.Purelin;
import com.maeiei.level.Level;
import com.maeiei.model.Matrix;
import com.maeiei.network.MultiNetwork;
import com.maeiei.network.Network;
import com.maeiei.network.NeuralNetwork;
import com.maeiei.rule.BackPropagationRule;

public class NeuralNetworkTest {

	@Test
	@Ignore
	public void testBackPropagationRule() {
		NeuralNetwork neuralNetwork = initNeuralNetwork();
		neuralNetwork.run();
		System.out.println(neuralNetwork.getOutput());
	}

	public void testBackPropagationRuleCirculation() {
		Network network = initNetwork();
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		int num = 0;
		while (num < 10000) {
			Matrix input = Matrix.unit(1, 0.0d);
			Matrix initResult = Matrix.unit(1, 1.0d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			// System.out.println(neuralNetwork.getOutput());
			input = Matrix.unit(1, 1.0d);
			initResult = Matrix.unit(1, 1.707d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			// System.out.println(neuralNetwork.getOutput());
			input = Matrix.unit(1, -1.0d);
			initResult = Matrix.unit(1, 0.29289d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			// System.out.println(neuralNetwork.getOutput());
			num++;
		}
		network.setInput(Matrix.unit(1, 2.0d));
		// network.setInitResult(Matrix.unit(1, 2.0d));
		neuralNetwork.setNetwork(network);
		neuralNetwork.forword();
		System.out.println(neuralNetwork.getOutput());
	}

	@Test
	public void testBackPropagationRuleCirculation1() {
		Network network = initNetwork();
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		int num = 0;
		while (num < 10000) {
			Matrix input = Matrix.unit(1, 1d);
			Matrix initResult = Matrix.unit(1, 2326.53d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 2d);
			initResult = Matrix.unit(1, 2318.30d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 3d);
			initResult = Matrix.unit(1, 2304.60d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 4d);
			initResult = Matrix.unit(1, 2331.95d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 5d);
			initResult = Matrix.unit(1, 2339.14d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 6d);
			initResult = Matrix.unit(1, 2296.55d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 7d);
			initResult = Matrix.unit(1, 2307.89d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 8d);
			initResult = Matrix.unit(1, 2315.93d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 9d);
			initResult = Matrix.unit(1, 2329.45d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			num++;
		}
		network.setInput(Matrix.unit(1, 10d)); // 2289.87
		neuralNetwork.setNetwork(network);
		neuralNetwork.forword();
		System.out.println(neuralNetwork.getOutput());
	}

	private Level initFirstLevel() {
		double[][] weightData = { { -0.27 }, { -0.41 }, { 0.1 }, { 0.2 }, { 0.3 }, { 0.4 }, { 0.5 } };
		double[][] biasData = { { -0.48 }, { -0.13 }, { 0.1 }, { 0.2 }, { 0.3 }, { 0.4 }, { 0.5 } };
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(weight, bias, logsig);
		return level;
	}

	private Level initSecondLevel() {
		double[][] weightSecondData = { { 0.09, -0.17, 0.1, 0.2, 0.3, 0.4, 0.5 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Level secondLevel = new Level(weightSecond, biasSecond, new Purelin());
		return secondLevel;
	}

	private Network initNetwork() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		Matrix input = Matrix.unit(1, 1.0d);
		Matrix initResult = Matrix.unit(1, 1.707d);
		Network network = new MultiNetwork(input, initResult);
		network.add(first);
		network.add(last);
		return network;
	}

	private NeuralNetwork initNeuralNetwork() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		Matrix input = Matrix.unit(1, 1.0d);
		Matrix initResult = Matrix.unit(1, 1.707d);
		Network network = new MultiNetwork(input, initResult);
		network.add(first);
		network.add(last);
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(last));
		return neuralNetwork;
	}
}
