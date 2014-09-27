package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import java.text.DecimalFormat;

import org.junit.Test;

import com.maeiei.Function;
import com.maeiei.Logsig;
import com.maeiei.Matrix;

public class LogsigTest {
	@Test
	public void testfunction() {
		double[][] matrixData = { { -0.75, -0.54 } };
		Matrix input = new Matrix(matrixData);

		Function function = new Logsig();
		Matrix actual = function.function(input);
		assertThat("", matrixData[0][0], is(matrixData[0][1]));
		// assertThat("乘积的行数为", actual.get(0, 1), is(0.368d));
		// assertThat("乘积的行数为", s, is("0.321"));
		// assertThat("乘积的行数为", actual.get(0, 1), is(0.368));
		System.out.println(actual);
	}
}
