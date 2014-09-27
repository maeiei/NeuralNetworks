package com.maeiei;

public class Logsig implements Function {

	@Override
	public Matrix function(Matrix matrix) {
		Matrix result = new Matrix(matrix.getRow(), matrix.getColumn());
		for (int i = 0; i < matrix.getRow(); i++)
			for (int j = 0; j < matrix.getColumn(); j++)
				result.set(i, j, calculateResult(matrix.get(i, j)));
		return result;
	}

	/**
	 * @param n
	 * @return a = 1 / (1 + e^-n)
	 */
	private double calculateResult(double n) {

		return 1 / (1 + Math.pow(Math.E, -n));
	}

	@Override
	public Matrix derivate(Matrix matrix) {
		Matrix one = new Matrix(matrix.getRow(), matrix.getColumn());
		return Operation.multiply(Operation.subtract(one, function(matrix)),
				function(matrix));
	}
}