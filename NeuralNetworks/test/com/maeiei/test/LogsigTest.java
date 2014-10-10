package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;
import java.text.DecimalFormat;
import org.junit.Test;
import com.maeiei.function.Function;
import com.maeiei.function.Logsig;
import com.maeiei.model.Matrix;

public class LogsigTest {
	@Test
	public void testLogsig() {
		double[][] matrixData = { { -0.75, -0.54 } };
		double[][] expectedData = { { 0.320821300824607, 0.3681875822638983 } };
		Matrix input = new Matrix(matrixData);

		Function function = new Logsig();
		Matrix actual = function.function(input);
		assertThat("乘积的行数为", actual.get(0, 1), is(expectedData[0][1]));
		DecimalFormat format = new DecimalFormat("#.000");
		assertThat("乘积的行数为", format.format(actual.get(0, 0)), equalTo(".321"));
		assertThat("乘积的行数为", format.format(actual.get(0, 1)), equalTo(".368"));
		System.out.println(actual);
	}
}
