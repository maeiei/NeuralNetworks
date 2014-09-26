package com.maeiei.test;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class FunctionTest {

	@Test
	public void testVectorMultiply() {
		int[][] w = { { 1, 2 } };
		int[][] p = { { 2 }, { 1 } };
		assertThat("当前格式化时间（yyyy-MM-dd HH:mm:ss）", w.length, is(1));
		assertThat("当前格式化时间（yyyy-MM-dd HH:mm:ss）", w[0].length, is(2));
		assertThat("当前格式化时间（yyyy-MM-dd HH:mm:ss）", p.length, is(2));
		assertThat("当前格式化时间（yyyy-MM-dd HH:mm:ss）", p[0].length, is(1));
	}
}
