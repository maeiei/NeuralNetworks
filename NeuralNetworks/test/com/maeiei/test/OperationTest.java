package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

import org.junit.Test;

import com.maeiei.Matrix;
import com.maeiei.MatrixInteger;
import com.maeiei.Operation;

public class OperationTest {
	
	@Test
	public void testAdd() {
		double[][] dataend = { { 0, 1 }, { 1, 2 } };
		double[][] dataenda = { { 1, 2 }, { 8, 9 } };
		Matrix addend = new Matrix(dataend);
		Matrix addenda = new Matrix(dataenda);
		Matrix sum = Operation.add(addend, addenda);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("�������", sum.get(i, j), is(dataend[i][j] + dataenda[i][j]));
	}
	
	@Test
	public void testAddSingle() {
		double[][] dataend = { { 0, 1 }, { 1, 2 } };
		Matrix addend = new Matrix(dataend);
		Matrix sum = Operation.add(addend, 2);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("����ӳ���", sum.get(i, j), is(dataend[i][j] + 2));
	}
	@Test
	public void testAddOther() {
		double[][] dataend = { { 0, 1, 2 }, { 1, 2, 3 } };
		double[][] dataenda = { { 0, 1, 2 }, { 1, 2, 3 } };
		Matrix addend = new Matrix(dataend);
		Matrix addenda = new Matrix(dataenda);
		Matrix sum = Operation.add(addend, addenda);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("�������", sum.get(i, j), is((double)(i + j) * 2));
	}

	@Test
	public void testMultiply() {
		double[][] w = { { 1, 2 } };
		double[][] p = { { 2 }, { 1 } };
		Matrix multiplier = new Matrix(w);
		Matrix multiplicand = new Matrix(p);
		Matrix product = Operation.multiply(multiplier, multiplicand);
		assertThat("�˻�������Ϊ", product.getRow(), is(1));
		assertThat("�˻�������Ϊ", product.getColumn(), is(1));
	}

	@Test
	public void testIntegetAdd() {
		int[][] dataend = { { 0, 1 }, { 1, 2 } };
		int[][] dataenda = { { 1, 2 }, { 8, 9 } };
		MatrixInteger addend = new MatrixInteger(dataend);
		MatrixInteger addenda = new MatrixInteger(dataenda);
		MatrixInteger sum = Operation.add(addend, addenda);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("�������", sum.get(i, j), is(dataend[i][j] + dataenda[i][j]));
	}

	@Test
	public void testAddIntegerSingle() {
		int[][] dataend = { { 0, 1 }, { 1, 2 } };
		MatrixInteger addend = new MatrixInteger(dataend);
		MatrixInteger sum = Operation.add(addend, 2);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("����ӳ���", sum.get(i, j), is(dataend[i][j] + 2));
	}

	@Test
	public void testAddIntegerOther() {
		int[][] dataend = { { 0, 1, 2 }, { 1, 2, 3 } };
		int[][] dataenda = { { 0, 1, 2 }, { 1, 2, 3 } };
		MatrixInteger addend = new MatrixInteger(dataend);
		MatrixInteger addenda = new MatrixInteger(dataenda);
		MatrixInteger sum = Operation.add(addend, addenda);
		for (int i = 0; i < sum.getRow(); i++)
			for (int j = 0; j < sum.getColumn(); j++)
				assertThat("�������", sum.get(i, j), is((i + j) * 2));
	}

	@Test
	public void testMultiplyInteger() {
		int[][] w = { { 1, 2 } };
		int[][] p = { { 2 }, { 1 } };
		MatrixInteger multiplier = new MatrixInteger(w);
		MatrixInteger multiplicand = new MatrixInteger(p);
		MatrixInteger product = Operation.multiply(multiplier, multiplicand);
		assertThat("�˻�������Ϊ", product.getRow(), is(1));
		assertThat("�˻�������Ϊ", product.getColumn(), is(1));
		System.out.println(multiplier);
	}
}
