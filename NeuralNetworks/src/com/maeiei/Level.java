package com.maeiei;

public class Level implements Nullable{

	private Level previousLevel;

	private Level nextLevel;

	private Matrix input;

	private Matrix initResult;

	private Matrix weight;

	private Matrix bias;

	private Matrix error;

	private Matrix output;

	private Matrix derivateOutput;

	private Matrix sensibility;

	private Matrix amendWeight;

	private Matrix amendBias;

	private Function function;
	
	protected Level() {
		this(null, null, null, null, null);
	}

	public Level(Matrix weight, Matrix bias, Function function) {
		this(weight, bias, function, NullLevel.getNull(), NullLevel.getNull());
	}

	public Level(Matrix weight, Matrix bias, Function function, Level previousLevel, Level nextLevel) {
		this.weight = weight;
		this.bias = bias;
		this.function = function;
		this.previousLevel = previousLevel;
		this.nextLevel = nextLevel;
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
		if (!hasNext())
			error = Operation.subtract(initResult, getOutput());
		return error;
	}

	public Matrix getOutput() {
		output = function.function(Operation.add(Operation.multiply(weight, input), bias));
		if (!hasNext())
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
		derivateOutput = function.derivate(Operation.add(Operation.multiply(weight, input), bias));
		return derivateOutput;
	}

	public boolean hasPrevious() {
		return previousLevel != null ? true : false;
	}

	public boolean hasNext() {
		return nextLevel != null ? true : false;
	}

	public Matrix getSensibility() {
		return sensibility;
	}

	public Matrix getAmendWeight() {
		return amendWeight;
	}

	public void setAmendWeight(Matrix amendWeight) {
		this.amendWeight = amendWeight;
	}

	public Matrix getAmendBias() {
		return amendBias;
	}

	public void setAmendBias(Matrix amendBias) {
		this.amendBias = amendBias;
	}

	public Level getPreviousLevel() {
		return previousLevel;
	}

	public void setPreviousLevel(Level previousLevel) {
		this.previousLevel = previousLevel;
	}

	public Level getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(Level nextLevel) {
		this.nextLevel = nextLevel;
	}

	@Override
	public boolean isNull() {
		return false;
	}
}
