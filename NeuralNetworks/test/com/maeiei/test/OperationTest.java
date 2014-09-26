package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import org.junit.Test;
import com.maeiei.MatrixInteger;
import com.maeiei.Operation;

public class OperationTest {

	@Test
	public void testAdd() {
		int[][] dataend = { { 0, 1 }, { 1, 2 } };
		int[][] dataenda = { { 1, 2 }, { 8, 9 } };
		MatrixInteger addend = new MatrixInteger(dataend);
		MatrixInteger addenda = new MatrixInteger(dataenda);
		MatrixInteger sum = Operation.add(addend, addenda);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("矩阵相加", sum.get(i, j), is(dataend[i][j] + dataenda[i][j]));
	}

	@Test
	public void testAddSingle() {
		int[][] dataend = { { 0, 1 }, { 1, 2 } };
		MatrixInteger addend = new MatrixInteger(dataend);
		MatrixInteger sum = Operation.add(addend, 2);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("矩阵加常数", sum.get(i, j), is(dataend[i][j] + 2));
	}

	@Test
	public void testAddOther() {
		int[][] dataend = { { 0, 1, 2 }, { 1, 2, 3 } };
		int[][] dataenda = { { 0, 1, 2 }, { 1, 2, 3 } };
		MatrixInteger addend = new MatrixInteger(dataend);
		MatrixInteger addenda = new MatrixInteger(dataenda);
		MatrixInteger sum = Operation.add(addend, addenda);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("矩阵相加", sum.get(i, j), is((i + j) * 2));
	}

	@Test
	public void testMultiply() {
		int[][] w = { { 1, 2 } };
		int[][] p = { { 2 }, { 1 } };
		MatrixInteger multiplier = new MatrixInteger(w);
		MatrixInteger multiplicand = new MatrixInteger(p);
		MatrixInteger product = Operation.multiply(multiplier, multiplicand);
		assertThat("乘积的行数为", product.getRow(), is(1));
		assertThat("乘积的列数为", product.getColumn(), is(1));
		System.out.println(multiplier);
	}
}
