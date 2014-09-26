package com.maeiei.test;

import org.junit.Ignore;
import org.junit.Test;
import com.maeiei.Level;
import com.maeiei.Matrix;
import com.maeiei.Purelin;

public class LevelTest {

	@Test
	@Ignore
	public void testSingleLevel() {
		int[][] inputData = { { -5 }, { 6 } };
		int[][] weightData = { { 3, 2 } };
		int[][] biasData = { { 1 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Level level = new Level(input, weight, bias, new Purelin());
		Matrix result = level.output();
		System.out.println(result);
	}

	@Test
	public void testSingleLevelAgain() {
		int[][] inputData = { { -1 }, { -1 }, { -1 } };
		int[][] weightData = { { 1, -1, -1 }, { 1, 1, -1 } };
		int[][] biasData = { { 3 }, { 3 } };
		Matrix input = new Matrix(inputData);
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Level level = new Level(input, weight, bias, new Purelin());
		Matrix result = level.output();
		System.out.println(result);
	}
}
