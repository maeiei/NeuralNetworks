package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import org.junit.Ignore;
import org.junit.Test;
import com.maeiei.MatrixInteger;

public class MatrixTest {

	@Test
	public void testMatrixInit() {
		int row = 1;
		int column = 2;
		MatrixInteger m = new MatrixInteger(row, column);
		assertThat("矩阵的行数：", m.getRow(), is(row));
		assertThat("矩阵的列数：", m.getColumn(), is(column));
		int[][] expectedData = { { 1, 2 }, { 3, 4 } };
		m = new MatrixInteger(expectedData);
		int[][] actualData = m.getData();
		assertThat("矩阵的行数：", m.getRow(), is(2));
		assertThat("矩阵的列数：", m.getColumn(), is(2));
		for (int i = 0; i < expectedData.length; i++)
			for (int j = 0; j < expectedData[i].length; j++)
				assertThat("", actualData[i][j], is(expectedData[i][j]));
	}

	@Test
	public void testInitRowData() {
		int[] row1 = { 1, 2 };
		int[] row2 = { 2, 1 };
		MatrixInteger m = new MatrixInteger(2, 2);
		int[][] expectedData = { { 1, 2 }, { 2, 1 } };
		int[][] actualData = m.initRowData(0, row1);
		assertThat("第1行，第1列：", actualData[0][0], is(expectedData[0][0]));
		assertThat("第1行，第2列：", actualData[0][1], is(expectedData[0][1]));
		actualData = m.initRowData(1, row2);
		assertThat("第2行，第1列：", actualData[1][0], is(expectedData[1][0]));
		assertThat("第21行，第2列：", actualData[1][1], is(expectedData[1][1]));
	}

	@Test
	public void initColumnData() {
		int[] column1 = { 1, 2 };
		int[] column2 = { 2, 1 };
		MatrixInteger m = new MatrixInteger(2, 2);
		int[][] expectedData = { { 1, 2 }, { 2, 1 } };
		int[][] actualData = m.initColumnData(0, column1);
		assertThat("第1行，第1列：", actualData[0][0], is(expectedData[0][0]));
		assertThat("第2行，第1列：", actualData[1][0], is(expectedData[1][0]));
		actualData = m.initColumnData(1, column2);
		assertThat("第1行，第2列：", actualData[0][1], is(expectedData[0][1]));
		assertThat("第2行，第2列：", actualData[1][1], is(expectedData[1][1]));
	}

	@Test
	@Ignore
	public void testToString() {
		int[][] two = { { 1, 2 }, { 2, 1 } };
		MatrixInteger matrix = new MatrixInteger(two);
		System.out.println(matrix);
		int[][] oneRow = { { 1, 2 } };
		matrix = new MatrixInteger(oneRow);
		System.out.println(matrix);
		int[][] oneColumn = { { 1 }, { 2 } };
		matrix = new MatrixInteger(oneColumn);
		System.out.println(matrix);
	}
}
