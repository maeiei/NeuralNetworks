package com.maeiei;

public class BackPropagationRule implements Rule {

	private static final double[][] constantData = { { -2 } };

	public static final Matrix CONSTANT = new Matrix(constantData);

	public static final double ALPHA = 0.1d;

	private Level last;

	private Matrix constant;

	private Matrix sensibility;

	private double alpha;

	public BackPropagationRule(Level level) {
		this(level, CONSTANT, ALPHA);
	}

	public BackPropagationRule(Network network) {
		this(network, CONSTANT, ALPHA);
	}

	public BackPropagationRule(Level level, Matrix constant, double alpha) {
		this.last = level;
		this.constant = constant;
		this.alpha = alpha;
	}

	public BackPropagationRule(Network network, Matrix constant, double alpha) {
		this.last = network.getLast();
		this.constant = constant;
		this.alpha = alpha;
	}

	public void amend() {
		Level next = last;
		do {
			amendSensibility(next);
			amendWeightAndBias(next);
			next = next.getPreviousLevel();
		} while (next.hasPrevious());
	}

	private void amendSensibility(Level level) {
		if (!level.hasNext()) {
			sensibility = Operation.multiply(Operation.multiply(constant, level.getDerivateOutput()),
					level.getError());
			level.setSensibility(sensibility);
		} else {
			Matrix jacobianData = level.getDerivateOutput().jacobian();
			sensibility = Operation.multiply(Operation.multiply(jacobianData, level.getNextLevel().getWeight()
					.transpose()), level.getNextLevel().getSensibility());
			level.setSensibility(sensibility);
		}
	}

	private void amendWeightAndBias(Level level) {
		if (!level.hasNext()) {
			setWeightAndBias(level);
		} else {
			level.getNextLevel().setWeight(level.getNextLevel().getAmendWeight());
			setWeightAndBias(level);
		}
	}

	private void setWeightAndBias(Level level) {
		if (!level.hasNext()) {
			level.setWeight(Operation.subtract(level.getWeight(),
					Operation.multiply(Operation.multiply(sensibility, alpha), level.getInput().transpose())));
			level.setBias(Operation.subtract(level.getBias(), Operation.multiply(sensibility, alpha)));
		} else {
			level.setAmendWeight(Operation.subtract(level.getWeight(),
					Operation.multiply(Operation.multiply(sensibility, alpha), level.getInput().transpose())));
			level.setAmendBias(Operation.subtract(level.getBias(), Operation.multiply(sensibility, alpha)));
		}
	}
}
