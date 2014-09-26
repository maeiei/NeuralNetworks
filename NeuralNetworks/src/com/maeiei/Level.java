package com.maeiei;

public class Level {

	private MatrixInteger input;

	private MatrixInteger weight;

	private MatrixInteger bias;

	private Function function;

	public Level(MatrixInteger input, MatrixInteger weight, MatrixInteger bias, Function function) {
		this.input = input;
		this.weight = weight;
		this.bias = bias;
		this.function = function;
	}

	public MatrixInteger output() {
		return function.function(Operation.add(Operation.multiply(weight, input), bias));
	}

	public MatrixInteger getInput() {
		return input;
	}

	public void setInput(MatrixInteger input) {
		this.input = input;
	}

	public MatrixInteger getWeight() {
		return weight;
	}

	public void setWeight(MatrixInteger weight) {
		this.weight = weight;
	}

	public MatrixInteger getBias() {
		return bias;
	}

	public void setBias(MatrixInteger bias) {
		this.bias = bias;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
}
