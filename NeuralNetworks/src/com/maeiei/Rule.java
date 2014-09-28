package com.maeiei;

public class Rule {

	private Level previousLevel;

	private Level currentLevel;

	private Matrix constant;

	private Matrix sensibility;

	private double alpha;

	public Rule(Level currentLevel, Level nextLevel, Matrix constant, double alpha) {
		this.currentLevel = currentLevel;
		this.previousLevel = nextLevel;
		this.constant = constant;
		this.alpha = alpha;
	}

	public Rule(Level currentLevel, Matrix constant, double alpha) {
		this(currentLevel, null, constant, alpha);
	}

	public void amendSensibility() {
		if (currentLevel.isLastLevel()) {
			sensibility = Operation.multiply(
					Operation.multiply(constant, currentLevel.getFunction().derivate(currentLevel.getInput())),
					currentLevel.getError());
			currentLevel.setSensibility(sensibility);
		} else {
			Matrix jacobianData = currentLevel.getDerivateOutput().jacobian();
			sensibility = Operation.multiply(
					Operation.multiply(jacobianData, previousLevel.getWeight().transpose()),
					previousLevel.getSensibility());
			currentLevel.setSensibility(sensibility);
		}
	}

	public Matrix amendWeight() {
		if (currentLevel.isLastLevel()) {
			return Operation.subtract(currentLevel.getWeight(), Operation.multiply(
					Operation.multiply(sensibility, alpha), currentLevel.getInput().transpose()));
		} else {
			return Operation.subtract(currentLevel.getWeight(), Operation.multiply(
					Operation.multiply(sensibility, alpha), currentLevel.getInput().transpose()));
		}
	}

	public Matrix amendBias() {
		if (currentLevel.isLastLevel()) {
			return Operation.subtract(currentLevel.getBias(), Operation.multiply(sensibility, alpha));
		} else {
			return Operation.subtract(currentLevel.getBias(), Operation.multiply(sensibility, alpha));
		}
	}

	public Level getLevel() {
		return currentLevel;
	}

	public void setLevel(Level level) {
		this.currentLevel = level;
	}

	public Matrix getSensibility() {
		return sensibility;
	}

	public void setSensibility(Matrix sensibility) {
		this.sensibility = sensibility;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	public Level getPreviousLevel() {
		return previousLevel;
	}

	public void setPreviousLevel(Level previousLevel) {
		this.previousLevel = previousLevel;
	}

	public Matrix getConstant() {
		return constant;
	}

	public void setConstant(Matrix constant) {
		this.constant = constant;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
}
