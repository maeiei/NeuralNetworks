package com.maeiei;

import com.maeiei.function.Function;

public class Purelin implements Function {

	@Override
	public Matrix function(Matrix matrix) {
		return matrix;
	}

	@Override
	public Matrix derivate(Matrix matrix) {
		return Matrix.unit(1, 1.0d);
	}
}
