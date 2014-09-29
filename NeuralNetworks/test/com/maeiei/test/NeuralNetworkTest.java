package com.maeiei.test;

import org.junit.Test;
import com.maeiei.BackPropagationRule;
import com.maeiei.Level;
import com.maeiei.Logsig;
import com.maeiei.Matrix;
import com.maeiei.NeuralNetwork;
import com.maeiei.Purelin;

public class NeuralNetworkTest {

	@Test
	public void testBackPropagationRule() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		double[][] inputData = { { 1 } };
		double[][] initResultData = { { 1.707 } };
		Matrix input = new Matrix(inputData);
		Matrix initResult = new Matrix(initResultData);
		NeuralNetwork neuralNetwork = new NeuralNetwork(new BackPropagationRule(last), input, initResult);
		neuralNetwork.addFirst(first);
		neuralNetwork.addLast(last);
		neuralNetwork.run();
		System.out.println(neuralNetwork.getOutput());
	}

	private Level initFirstLevel() {
		double[][] weightData = { { -0.27 }, { -0.41 } };
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(weight, bias, logsig, true, false);
		return level;
	}

	private Level initSecondLevel() {
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Level secondLevel = new Level(weightSecond, biasSecond, new Purelin(), false,
				true);
		return secondLevel;
	}
}
