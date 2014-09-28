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
		double[][] inputData = { { 1 } };
		double[][] initResultData = { { 1.707 } };
		double[][] weightData = { { -0.27 }, { -0.41 } };
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix input = new Matrix(inputData);
		Matrix initResult = new Matrix(initResultData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(input, initResult, weight, bias, logsig, false);
		Matrix firstOutput = level.getOutput();
		System.out.println("第一层输出：" + firstOutput);
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Purelin purelin = new Purelin();
		Level secondLevel = new Level(firstOutput, initResult, weightSecond, biasSecond, purelin, true);
		System.out.println("第一次误差为：" + secondLevel.getError());
		double[][] constantData = { { -2 } };
		Matrix constant = new Matrix(constantData);
		double alpha = 0.1d;
		Rule secondRule = new Rule(secondLevel, constant, alpha);
		Rule firstRule = new Rule(level, secondLevel, constant, alpha);
		secondRule.amendSensibility();
		firstRule.amendSensibility();
		Matrix amendWeight = secondRule.amendWeight();
		Matrix amendBias = secondRule.amendBias();
		Matrix firstWeight = firstRule.amendWeight();
		Matrix firstBias = firstRule.amendBias();
		secondLevel.setWeight(amendWeight);
		secondLevel.setBias(amendBias);
		level.setWeight(firstWeight);
		level.setBias(firstBias);
		System.out.println(level.getOutput());
		secondLevel.setInput(level.getOutput());
		System.out.println(secondLevel.getOutput());
		System.out.println("第二次误差为：" + secondLevel.getError());
	}
}
