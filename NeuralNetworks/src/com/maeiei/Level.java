package com.maeiei;

public class Level {

	private boolean lastLevel;

	private Matrix input;

	private Matrix initResult;

	private Matrix weight;

	private Matrix bias;

	private Matrix error;

	private Matrix output;

	private Matrix derivateOutput;

	private Matrix sensibility;

	private Function function;

	public Level(Matrix input, Matrix initResult, Matrix weight, Matrix bias,
			Function function, boolean lastLevel) {
		this.input = input;
		this.initResult = initResult;
		this.weight = weight;
		this.bias = bias;
		this.function = function;
		this.lastLevel = lastLevel;
		calculateDerivate(input, weight, bias, function);
		if(isLastLevel())
			error = Operation.subtract(initResult, output);
	}

	public Level(Matrix input, Matrix weight, Matrix bias, Function function,
			boolean lastLevel) {
		this.input = input;
		this.weight = weight;
		this.bias = bias;
		this.function = function;
		this.lastLevel = lastLevel;
		calculateDerivate(input, weight, bias, function);
		if(isLastLevel())
			error = Operation.subtract(initResult, output);
	}

	private void calculateDerivate(Matrix input, Matrix weight, Matrix bias,
			Function function) {
		output = function.function(Operation.add(
				Operation.multiply(weight, input), bias));
		derivateOutput = function.derivate(Operation.add(
				Operation.multiply(weight, input), bias));
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
		return error;
	}

	public Matrix getOutput() {
		calculateDerivate(input, weight, bias, function);
		if(isLastLevel())
			error = Operation.subtract(initResult, output);
		return output;
	}

	public void setOutput(Matrix output) {
		this.output = output;
	}

	public void setSensibility(Matrix sensibility) {
		this.sensibility = sensibility;
	}

	public Matrix getDerivateOutput() {
		calculateDerivate(input, weight, bias, function);
		if(isLastLevel())
			error = Operation.subtract(initResult, output);
		return derivateOutput;
	}

	public boolean isLastLevel() {
		return lastLevel;
	}

	public void setLastLevel(boolean lastLevel) {
		this.lastLevel = lastLevel;
	}

	public Matrix getSensibility() {
		return sensibility;
	}
}
