package com.maeiei.test;

import org.junit.Test;
import com.maeiei.Level;
import com.maeiei.Logsig;
import com.maeiei.Matrix;
import com.maeiei.Purelin;
import com.maeiei.Rule;

public class RuleTest {

	@Test
	public void testRule() {
		Level level = initFirstLevel();
		Level secondLevel = initSecondLevel(level.getOutput());
		Rule secondRule = new Rule(secondLevel);
		Rule firstRule = new Rule(level, secondLevel);
		secondRule.amend();
		firstRule.amend();
	}

	private Level initFirstLevel() {
		double[][] inputData = { { 1 } };
		double[][] initResultData = { { 1.707 } };
		double[][] weightData = { { -0.27 }, { -0.41 } };
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix input = new Matrix(inputData);
		Matrix initResult = new Matrix(initResultData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(input, initResult, weight, bias, logsig, true, false);
		return level;
	}

	private Level initSecondLevel(Matrix firstOutput) {
		double[][] initResultData = { { 1.707 } };
		Matrix initResult = new Matrix(initResultData);
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Level secondLevel = new Level(firstOutput, initResult, weightSecond, biasSecond, new Purelin(), false,
				true);
		return secondLevel;
	}
}
