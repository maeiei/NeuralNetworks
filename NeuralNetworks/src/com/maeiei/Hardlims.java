package com.maeiei;

public class Hardlims implements Function {

	@Override
	public Matrix function(Matrix matrix) {
		if (matrix.getRow() != 1 || matrix.getColumn() != 1)
			throw new IllegalArgumentException("矩阵的维度必须等于1！");
		if (matrix.get(0, 0) >= 0) {
			return new Matrix(1, 1);
		} else {
			return new Matrix(1, -1);
		}
	}

	@Override
	public Matrix derivate(Matrix matrix) {
		throw new UnsupportedOperationException("对称硬极限函数不支持导数！");
	}
}
