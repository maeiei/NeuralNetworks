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

	public void set(int row, int column, int value) {
		data[row][column] = value;
	}

	@Override
	public String toString() {
		StringBuilder dataBuilder = new StringBuilder(128);
		dataBuilder.append("矩阵的维度为：" + this.getRow() + " * " + this.getColumn());
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
