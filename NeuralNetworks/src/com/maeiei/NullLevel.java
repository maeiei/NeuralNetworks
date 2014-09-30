package com.maeiei;

public class NullLevel extends Level implements Nullable {

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
}
