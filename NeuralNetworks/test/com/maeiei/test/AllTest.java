package com.maeiei.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses({ BackPropagationRuleTest.class, FunctionTest.class, LevelTest.class, LogsigTest.class,
		MatrixTest.class, OperationTest.class, NeuralNetworkTest.class })
public class AllTest {
}
