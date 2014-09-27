package com.maeiei.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.maeiei.Level;
import com.maeiei.Logsig;
import com.maeiei.Matrix;
import com.maeiei.Purelin;

public class LevelTest {

	@Test
	@Ignore
	public void testSingleLevel() {
		double[][] inputData = { { -5 }, { 6 } };
		double[][] weightData = { { 3, 2 } };
		double[][] biasData = { { 1 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Level level = new Level(input, weight, bias, new Purelin());
		Matrix result = level.getOutput();
		assertEquals("�����������", result.getRow(), 1);
		assertEquals("�����������", result.getColumn(), 1);
		assertEquals("��һ�У�", result.get(0, 0), -2.0, 0);
	}

	@Test
	@Ignore
	public void testSingleLevelAgain() {
		double[][] inputData = { { -1 }, { -1 }, { -1 } };
		double[][] weightData = { { 1, -1, -1 }, { 1, 1, -1 } };
		double[][] biasData = { { 3 }, { 3 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Level level = new Level(input, weight, bias, new Purelin());
		Matrix result = level.getOutput();
		assertEquals("�����������", result.getRow(), 2);
		assertEquals("�����������", result.getColumn(), 1);
		assertEquals("��һ�У�", result.get(0, 0), 4.0, 0);
		assertEquals("�ڶ��У�", result.get(1, 0), 2.0, 0);
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

		Level level = new Level(input, initResult, weight, bias, logsig);

		Matrix firstOutput = level.getOutput();

		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };

		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Purelin purelin = new Purelin();
		Level secondLevel = new Level(firstOutput, initResult, weightSecond,
				biasSecond, purelin);
		System.out.println(secondLevel.getOutput());
		Matrix errorSecond = secondLevel.getError();
		System.out.println(errorSecond);
		
		
		
		
	}
}
