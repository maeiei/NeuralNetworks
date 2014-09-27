package com.maeiei;

public class Purelin implements Function {

	@Override
	public Matrix function(Matrix matrix) {
		return matrix;
	}

	@Override
	public Matrix derivate(Matrix matrix) {
		double[][] result = { { 1 } };
		return new Matrix(result);
	}
}
