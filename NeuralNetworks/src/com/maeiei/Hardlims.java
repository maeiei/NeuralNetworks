package com.maeiei;

public class Hardlims implements Function {

	@Override
	public Matrix function(Matrix matrix) {
		if (matrix.getRow() != 1 || matrix.getColumn() != 1)
			throw new IllegalArgumentException("�����ά�ȱ������1��");
		if (matrix.get(0, 0) >= 0) {
			return new Matrix(1, 1);
		} else {
			return new Matrix(1, -1);
		}
	}

	@Override
	public Matrix derivate(Matrix matrix) {
		throw new UnsupportedOperationException("�Գ�Ӳ���޺�����֧�ֵ�����");
	}
}
