package com.maeiei.test;

import org.junit.Ignore;
import org.junit.Test;
import com.maeiei.Level;
import com.maeiei.MatrixInteger;
import com.maeiei.Purelin;

public class LevelTest {

	@Test
	@Ignore
	public void testSingleLevel() {
		int[][] inputData = { { -5 }, { 6 } };
		int[][] weightData = { { 3, 2 } };
		int[][] biasData = { { 1 } };
		MatrixInteger input = new MatrixInteger(inputData);
		MatrixInteger weight = new MatrixInteger(weightData);
		MatrixInteger bias = new MatrixInteger(biasData);
		Level level = new Level(input, weight, bias, new Purelin());
		MatrixInteger result = level.output();
		System.out.println(result);
	}

	@Test
	public void testSingleLevelAgain() {
		int[][] inputData = { { -1 }, { -1 }, { -1 } };
		int[][] weightData = { { 1, -1, -1 }, { 1, 1, -1 } };
		int[][] biasData = { { 3 }, { 3 } };
		MatrixInteger input = new MatrixInteger(inputData);
		MatrixInteger weight = new MatrixInteger(weightData);
		MatrixInteger bias = new MatrixInteger(biasData);
		Level level = new Level(input, weight, bias, new Purelin());
		MatrixInteger result = level.output();
		System.out.println(result);
	}
}
