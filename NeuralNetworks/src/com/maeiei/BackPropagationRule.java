package com.maeiei;

public class BackPropagationRule implements Rule{
	
	private static final double[][] constantData = { { -2 } };

	public static final Matrix CONSTANT = new Matrix(constantData);

	public static final double ALPHA = 0.1d;

	private Level previousLevel;

	private Level currentLevel;

	private Matrix constant;

	private Matrix sensibility;

	private double alpha;

	public BackPropagationRule(Level currentLevel) {
		this(currentLevel, null, CONSTANT, ALPHA);
	}

	public BackPropagationRule(Level currentLevel, Level nextLevel) {
		this(currentLevel, nextLevel, CONSTANT, ALPHA);
	}

	public BackPropagationRule(Level currentLevel, Matrix constant, double alpha) {
		this(currentLevel, null, constant, alpha);
	}

	public BackPropagationRule(Level currentLevel, Level nextLevel, Matrix constant, double alpha) {
		this.currentLevel = currentLevel;
		this.previousLevel = nextLevel;
		this.constant = constant;
		this.alpha = alpha;
	}

	public void amend() {
		amendSensibility();
		amendWeightAndBias();
	}

	private void amendSensibility() {
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

	private void amendWeightAndBias() {
		if (currentLevel.isLastLevel()) {
			setWeightAndBias();
		} else {
			previousLevel.setWeight(previousLevel.getAmendWeight());
			setWeightAndBias();
		}
	}

	private void setWeightAndBias() {
		if (currentLevel.isFirstHead()) {
			currentLevel.setWeight(Operation.subtract(currentLevel.getWeight(), Operation.multiply(
					Operation.multiply(sensibility, alpha), currentLevel.getInput().transpose())));
			currentLevel
					.setBias(Operation.subtract(currentLevel.getBias(), Operation.multiply(sensibility, alpha)));
		} else {
			currentLevel.setAmendWeight(Operation.subtract(currentLevel.getWeight(), Operation.multiply(
					Operation.multiply(sensibility, alpha), currentLevel.getInput().transpose())));
			currentLevel.setAmendBias(Operation.subtract(currentLevel.getBias(),
					Operation.multiply(sensibility, alpha)));
		}
	}
}
