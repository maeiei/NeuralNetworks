package com.maeiei;

public class Operation {

	public static Matrix add(Matrix addend, Matrix addenda) {
		if (addend.getRow() != addenda.getRow()
				|| addend.getColumn() != addenda.getColumn())
			throw new IllegalArgumentException("两个矩阵的维度必须相等！");
		Matrix sum = new Matrix(addend.getRow(), addend.getColumn());
		for (int i = 0; i < addend.getRow(); i++)
			for (int j = 0; j < addend.getColumn(); j++)
				sum.set(i, j, addend.get(i, j) + addenda.get(i, j));
		return sum;
	}

	public static Matrix subtract(Matrix addend, Matrix addenda) {
		if (addend.getRow() != addenda.getRow()
				|| addend.getColumn() != addenda.getColumn())
			throw new IllegalArgumentException("两个矩阵的维度必须相等！");
		Matrix sum = new Matrix(addend.getRow(), addend.getColumn());
		for (int i = 0; i < addend.getRow(); i++)
			for (int j = 0; j < addend.getColumn(); j++)
				sum.set(i, j, addend.get(i, j) - addenda.get(i, j));
		return sum;
	}

	/**
	 * 乘法
	 * 
	 * @param multiplier
	 * @param multiplicand
	 * @return
	 */
	public static Matrix multiply(Matrix multiplier, Matrix multiplicand) {
		if (multiplier.getColumn() != multiplicand.getRow())
			throw new IllegalArgumentException("行必须等于列！");
		Matrix product = new Matrix(multiplier.getRow(),
				multiplicand.getColumn());
		for (int i = 0; i < multiplier.getRow(); i++)
			for (int j = 0; j < multiplicand.getColumn(); j++)
				product.set(i, j,
						calculateSingleResult(multiplier, multiplicand, i, j));
		return product;
	}

	/**
	 * 标量乘法
	 * 
	 * @param multiplier
	 * @param multiplicand
	 * @return
	 */
	public static Matrix multiply(Matrix multiplier, double multiplicand) {
		Matrix result = new Matrix(multiplier.getRow(), multiplier.getColumn());
		for (int i = 0; i < result.getRow(); i++)
			for (int j = 0; j < result.getColumn(); j++)
				result.set(i, j, multiplier.get(i, j) * multiplicand);
		return result;
	}

	public static Matrix add(Matrix addend, double addenda) {
		Matrix sum = new Matrix(addend.getRow(), addend.getColumn());
		for (int i = 0; i < addend.getRow(); i++)
			for (int j = 0; j < addend.getColumn(); j++)
				sum.set(i, j, addend.get(i, j) + addenda);
		return sum;
	}

	/**
	 * 除法
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
//	public static Matrix divide(Matrix dividend, Matrix divisor) {
//		if (dividend.getRow() != divisor.getRow()
//				|| dividend.getColumn() != divisor.getColumn())
//			throw new IllegalArgumentException("两个矩阵的维度必须相等！");
//		Matrix sum = new Matrix(dividend.getRow(), dividend.getColumn());
//		for (int i = 0; i < dividend.getRow(); i++)
//			for (int j = 0; j < dividend.getColumn(); j++)
//				sum.set(i, j, dividend.get(i, j) / divisor.get(i, j));
//		return sum;
//	}

	private static double calculateSingleResult(Matrix multiplier,
			Matrix multiplicand, int row, int column) {
		double sum = 0;
		for (int i = 0; i < multiplier.getColumn(); i++)
			sum += multiplier.get(row, i) * multiplicand.get(i, column);
		return sum;
	}
}
