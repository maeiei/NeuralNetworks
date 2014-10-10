package com.maeiei.function;

import com.maeiei.model.Matrix;

public interface Function {

	public Matrix function(Matrix matrix);
	
	public Matrix derivate(Matrix matrix);
}
