package com.maeiei.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maeiei.function.Logsig;
import com.maeiei.function.Purelin;
import com.maeiei.level.Level;
import com.maeiei.model.Matrix;
import com.maeiei.operation.Operation;

public class LevelTest {

	@Test
	public void testSingleLevel() {
		double[][] inputData = { { -5 }, { 6 } };
		double[][] weightData = { { 3, 2 } };
		double[][] biasData = { { 1 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Level level = new Level(weight, bias, new Purelin());
		level.setInput(input);
		Matrix result = level.getOutput();
		assertEquals("结果的行数：", result.getRow(), 1);
		assertEquals("结果的列数：", result.getColumn(), 1);
		assertEquals("第一行：", result.get(0, 0), -2.0, 0);
	}

	@Test
	public void testSingleLevelAgain() {
		double[][] inputData = { { -1 }, { -1 }, { -1 } };
		double[][] weightData = { { 1, -1, -1 }, { 1, 1, -1 } };
		double[][] biasData = { { 3 }, { 3 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Level level = new Level(weight, bias, new Purelin());
		level.setInput(input);
		Matrix result = level.getOutput();
		assertEquals("结果的行数：", result.getRow(), 2);
		assertEquals("结果的列数：", result.getColumn(), 1);
		assertEquals("第一行：", result.get(0, 0), 4.0, 0);
		assertEquals("第二行：", result.get(1, 0), 2.0, 0);
	}

	@Test
	public void testSimulationBP() {
		double[][] inputData = { { 1 } };
		double[][] initResultData = { { 1.707 } };
		double[][] weightData = { { -0.27 }, { -0.41 } };
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix input = new Matrix(inputData);
		Matrix initResult = new Matrix(initResultData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(weight, bias, logsig);
		level.setInput(input);
		Matrix firstOutput = level.getOutput();
		System.out.println("第一层输出：" + firstOutput);
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Purelin purelin = new Purelin();
		Level secondLevel = new Level(weightSecond, biasSecond, purelin);
		secondLevel.setInput(firstOutput);
		secondLevel.setInitResult(initResult);
		Matrix secondOutput = secondLevel.getOutput();
		System.out.println("第二层输出：" + secondOutput);
		Matrix errorSecond = secondLevel.getError();
		double[][] constantData = { { -2 } };
		Matrix constant = new Matrix(constantData);
		Matrix sensibility2 = Operation.multiply(Operation.multiply(constant, purelin.derivate(firstOutput)),
				errorSecond);
		Matrix jacobianData = level.getDerivateOutput().jacobian();
		System.out.println("雅克比矩阵：" + jacobianData);
		Matrix sensibility = Operation.multiply(Operation.multiply(jacobianData, weightSecond.transpose()),
				sensibility2);
		System.out.println(sensibility);
	}
}
