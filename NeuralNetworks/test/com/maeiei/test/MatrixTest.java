package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import com.maeiei.model.Matrix;

public class MatrixTest {

	@Test
	public void testMatrixInit() {
		int row = 1;
		int column = 2;
		Matrix m = new Matrix(row, column);
		assertThat("矩阵的行数：", m.getRow(), is(row));
		assertThat("矩阵的列数：", m.getColumn(), is(column));
		double[][] expectedData = { { 1, 2 }, { 3, 4 } };
		m = new Matrix(expectedData);
		double[][] actualData = m.getData();
		assertThat("矩阵的行数：", m.getRow(), is(2));
		assertThat("矩阵的列数：", m.getColumn(), is(2));
		for (int i = 0; i < expectedData.length; i++)
			for (int j = 0; j < expectedData[i].length; j++)
				assertThat("", actualData[i][j], is(expectedData[i][j]));
	}

	@Test
	public void testToString() {
		double[][] two = { { 1, 2 }, { 2, 1 } };
		Matrix matrix = new Matrix(two);
		System.out.println(matrix);
		double[][] oneRow = { { 1, 2 } };
		matrix = new Matrix(oneRow);
		System.out.println(matrix);
		double[][] oneColumn = { { 1 }, { 2 } };
		matrix = new Matrix(oneColumn);
		System.out.println(matrix);
	}

	@Test
	public void testTranspose() {
		double[][] init = { { 0.321, 0.368 } };
		Matrix matrix = new Matrix(init);
		System.out.println(matrix.transpose());
	}

}
