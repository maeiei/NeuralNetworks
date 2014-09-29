package com.maeiei;

public class Matrix {

	private static final int DEFAULT_LENGTH = 8;

	private int row;

	private int column;

	private double[][] data;

	public Matrix() {
		this(DEFAULT_LENGTH, DEFAULT_LENGTH);
	}

	public Matrix(int row, int column) {
		if (row <= 0 || column <= 0)
			throw new IllegalArgumentException("矩阵的维度必须大于0！");
		this.row = row;
		this.column = column;
		data = new double[row][column];
	}

//	public static Matrix unit(int width) {
//		Matrix result = new Matrix(width, width);
//
//		for (int i = 0; i < width; i++)
//			for (int j = 0; j < width; j++)
//				if (i == j)
//					result.set(i, j, 1);
//		return result;
//	}

	public Matrix jacobian() {
		if (row != column)
			throw new IllegalArgumentException("矩阵的行列必须相等！");
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				if (i != j)
					set(i, j, 0);
		return this;
	}

	public static Matrix allOne(int row, int column) {
		Matrix result = new Matrix(row, column);

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				result.set(i, j, 1);
		return result;
	}

	public Matrix transpose() {
		Matrix transposition = new Matrix(column, row);

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				transposition.set(j, i, this.get(i, j));
		return transposition;
	}

	public Matrix(double[][] data) {
		this.row = data.length;
		this.column = data[0].length;
		this.data = data;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public double[][] getData() {
		return data;
	}

	public double get(int row, int column) {
		return data[row][column];
	}

	public void set(int row, int column, double value) {
		data[row][column] = value;
	}

	@Override
	public String toString() {
		StringBuilder dataBuilder = new StringBuilder(128);
		dataBuilder
				.append("矩阵的维度为：" + this.getRow() + " * " + this.getColumn());
		dataBuilder.append("\n");
		for (double[] rowData : data) {
			for (double columnData : rowData) {
				dataBuilder.append(columnData);
				dataBuilder.append("\t");
			}
			dataBuilder.append("\n");
		}
		return dataBuilder.toString();
	}
}
