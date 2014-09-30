package com.maeiei.test;

import org.junit.Test;
import com.maeiei.Level;
import com.maeiei.Matrix;
import com.maeiei.BackPropagationRule;
import com.maeiei.function.Logsig;
import com.maeiei.function.Purelin;

public class BackPropagationRuleTest {

	@Test
	public void testBackPropagationRule() {
		Level level = initFirstLevel();
		Level secondLevel = initSecondLevel(level.getOutput());
		level.setNextLevel(secondLevel);
		System.out.println(secondLevel.getOutput());
		BackPropagationRule rule = new BackPropagationRule(secondLevel);
		rule.amend();
		System.out.println(secondLevel.getOutput());
	}

	private Level initFirstLevel() {
		double[][] inputData = { { 1 } };
		double[][] weightData = { { -0.27 }, { -0.41 } };
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(weight, bias, logsig);
		level.setInput(input);
		return level;
	}

	private Level initSecondLevel(Matrix firstOutput) {
		double[][] initResultData = { { 1.707 } };
		Matrix initResult = new Matrix(initResultData);
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Level secondLevel = new Level(weightSecond, biasSecond, new Purelin());
		secondLevel.setInput(firstOutput);
		secondLevel.setInitResult(initResult);
		return secondLevel;
	}
}
