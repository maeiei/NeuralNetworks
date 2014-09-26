package com.maeiei;

public class Level {

	private Matrix input;

	private Matrix weight;

	private Matrix bias;

	private Function function;

	public Level(Matrix input, Matrix weight, Matrix bias, Function function) {
		this.input = input;
		this.weight = weight;
		this.bias = bias;
		this.function = function;
	}

	public Matrix output() {
		return function.function(Operation.add(Operation.multiply(weight, input), bias));
	}

	public Matrix getInput() {
		return input;
	}

	public void setInput(Matrix input) {
		this.input = input;
	}

	public Matrix getWeight() {
		return weight;
	}

	public void setWeight(Matrix weight) {
		this.weight = weight;
	}

	public Matrix getBias() {
		return bias;
	}

	public void setBias(Matrix bias) {
		this.bias = bias;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
}
