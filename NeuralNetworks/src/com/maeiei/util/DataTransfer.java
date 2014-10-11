package com.maeiei.util;

import com.maeiei.model.Data;
import com.maeiei.model.Matrix;

public class DataTransfer {

	public static Matrix transferInput(Data data) {
		Matrix matrix = Matrix.unit(1, 1);
		matrix.set(0, 0, data.getId());
		return matrix;
	}
	public static Matrix transferResult(Data data) {
		Matrix matrix = Matrix.unit(1, 1);
		matrix.set(0, 0, data.getClose());
		return matrix;
	}
}
