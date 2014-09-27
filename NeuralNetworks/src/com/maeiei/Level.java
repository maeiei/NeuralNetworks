package com.maeiei;

public class Level {

	private Matrix input;

	private Matrix initResult;

	private Matrix weight;

	private Matrix bias;

	private Matrix error;

	private Matrix output;

	private Function function;

	public Level(Matrix input, Matrix initResult, Matrix weight, Matrix bias,
			Function function) {
		this.input = input;
		this.initResult = initResult;
		this.weight = weight;
		this.bias = bias;
		this.function = function;
	}

	public Level(Matrix input, Matrix weight, Matrix bias, Function function) {
		this.input = input;
		this.weight = weight;
		this.bias = bias;
		this.function = function;
	}

	public Matrix backForward() {

		return bias;

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

	public Matrix getInitResult() {
		return initResult;
	}

	public void setInitResult(Matrix initResult) {
		this.initResult = initResult;
	}

	public Matrix getError() {
		error = Operation.subtract(initResult, output);
		return error;
	}

	public Matrix getOutput() {
		output = function.function(Operation.add(
				Operation.multiply(weight, input), bias));
		return output;
	}

	public void setOutput(Matrix output) {
		this.output = output;
	}

}
