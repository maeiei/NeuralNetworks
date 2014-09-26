package com.maeiei;

public class Operation {

	public static MatrixInteger add(MatrixInteger addend, MatrixInteger addenda) {
		if (addend.getRow() != addenda.getRow() || addend.getColumn() != addenda.getColumn())
			throw new IllegalArgumentException("两个矩阵的维度必须相等！");
		MatrixInteger sum = new MatrixInteger(addend.getRow(), addend.getColumn());
		for (int i = 0; i < addend.getRow(); i++)
			for (int j = 0; j < addend.getColumn(); j++)
				sum.set(i, j, addend.get(i, j) + addenda.get(i, j));
		return sum;
	}

	public static MatrixInteger add(MatrixInteger addend, int addenda) {
		MatrixInteger sum = new MatrixInteger(addend.getRow(), addend.getColumn());
		for (int i = 0; i < addend.getRow(); i++)
			for (int j = 0; j < addend.getColumn(); j++)
				sum.set(i, j, addend.get(i, j) + addenda);
		return sum;
	}

	public static MatrixInteger multiply(MatrixInteger multiplier, MatrixInteger multiplicand) {
		if (multiplier.getColumn() != multiplicand.getRow())
			throw new IllegalArgumentException("行必须等于列！");
		MatrixInteger product = new MatrixInteger(multiplier.getRow(), multiplicand.getColumn());
		for (int i = 0; i < multiplier.getRow(); i++)
			for (int j = 0; j < multiplicand.getColumn(); j++)
				product.set(i, j, calculateSingleResult(multiplier, multiplicand, i, j));
		return product;
	}

	private static int calculateSingleResult(MatrixInteger multiplier, MatrixInteger multiplicand, int row, int column) {
		int sum = 0;
		for (int i = 0; i < multiplier.getColumn(); i++)
			sum += multiplier.get(row, i) * multiplicand.get(i, column);
		return sum;
	}
}
