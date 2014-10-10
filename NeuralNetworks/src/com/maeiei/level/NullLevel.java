package com.maeiei.level;

import com.maeiei.model.Matrix;

public class NullLevel extends Level {

	private static final NullLevel nullLevel = new NullLevel();

	@Override
	public boolean isNull() {
		return true;
	}

	public static Level getNull() {
		return nullLevel;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public boolean isNotNull() {
		return false;
	}

	@Override
	public Matrix getOutput() {
		return Matrix.unit(1, 0.0d);
	}
}
