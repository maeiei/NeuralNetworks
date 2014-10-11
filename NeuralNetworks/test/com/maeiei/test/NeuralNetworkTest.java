package com.maeiei.test;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.maeiei.dao.DataMapper;
import com.maeiei.dao.ResultDataMapper;
import com.maeiei.function.Logsig;
import com.maeiei.function.Purelin;
import com.maeiei.level.Level;
import com.maeiei.model.Data;
import com.maeiei.model.DataCriteria;
import com.maeiei.model.DataCriteria.Criteria;
import com.maeiei.model.Matrix;
import com.maeiei.network.MultiNetwork;
import com.maeiei.network.Network;
import com.maeiei.network.NeuralNetwork;
import com.maeiei.rule.BackPropagationRule;
import com.maeiei.util.DataTransfer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring.xml" })
public class NeuralNetworkTest {

	@Resource(name = "dataMapper")
	private DataMapper dataMapper;

	@Resource(name = "resultDataMapper")
	private ResultDataMapper resultDataMapper;

	@Test
	@Ignore
	public void testBackPropagationRule() {
		NeuralNetwork neuralNetwork = initNeuralNetwork();
		neuralNetwork.run();
		System.out.println(neuralNetwork.getOutput());
	}

	@Test	
	public void testBackPropagationRuleData() {
		Network network = initNetwork();
		List<Data> data = dataMapper.selectByCriteria(initCondition());
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network), data, data);
		int num = 0;
		while (num < 10000) {
			for (int i = 0; i < data.size(); i++) {
				Matrix matrix = Matrix.unit(1, 1);
				matrix.set(0, 0, i);
				network.setInput(matrix);
				network.setInitResult(DataTransfer.transferResult(data.get(i)));
				neuralNetwork.setNetwork(network);
				neuralNetwork.run();
			}
			num++;
		}
		Level head = network.getHead();
		while(head.isNotNull()){
			System.out.println("权值：" + head.getWeight());
			System.out.println("偏置值：" + head.getBias());
			head = head.getNextLevel();
		}
		for (int i = 0; i < data.size(); i++) {
			Matrix matrix = Matrix.unit(1, 1);
			matrix.set(0, 0, i);
			network.setInput(matrix);
			network.setInitResult(DataTransfer.transferResult(data.get(i)));
			neuralNetwork.setNetwork(network);
			neuralNetwork.forword();
			System.out.println("结果：" + neuralNetwork.getOutput());
		}
	}

	private DataCriteria initCondition() {
		DataCriteria criterias = new DataCriteria();
		Criteria criteria = criterias.createCriteria();
		criteria.andIdLessThan(5632);
		return criterias;
	}

	@Test
	@Ignore
	public void testBackPropagationRuleCirculation() {
		Network network = initNetwork();
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		int num = 0;
		while (num < 100000) {
			Matrix input = Matrix.unit(1, 0.0d);
			Matrix initResult = Matrix.unit(1, 1.0d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			// System.out.println(neuralNetwork.getOutput());
			input = Matrix.unit(1, 1.0d);
			initResult = Matrix.unit(1, 1.707d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			// System.out.println(neuralNetwork.getOutput());
			input = Matrix.unit(1, -1.0d);
			initResult = Matrix.unit(1, 0.29289d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			// System.out.println(neuralNetwork.getOutput());
			num++;
		}
		network.setInput(Matrix.unit(1, 1.0d));
		// network.setInitResult(Matrix.unit(1, 2.0d));
		neuralNetwork.setNetwork(network);
		neuralNetwork.forword();
		System.out.println(neuralNetwork.getOutput());
	}

	@Test
	@Ignore
	public void testBackPropagationRuleCirculation1() {
		Network network = initNetwork();
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(network));
		int num = 0;
		while (num < 10000) {
			Matrix input = Matrix.unit(1, 1d);
			Matrix initResult = Matrix.unit(1, 2326.53d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 2d);
			initResult = Matrix.unit(1, 2318.30d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 3d);
			initResult = Matrix.unit(1, 2304.60d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 4d);
			initResult = Matrix.unit(1, 2331.95d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 5d);
			initResult = Matrix.unit(1, 2339.14d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 6d);
			initResult = Matrix.unit(1, 2296.55d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 7d);
			initResult = Matrix.unit(1, 2307.89d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 8d);
			initResult = Matrix.unit(1, 2315.93d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			input = Matrix.unit(1, 9d);
			initResult = Matrix.unit(1, 2329.45d);
			network.setInput(input);
			network.setInitResult(initResult);
			neuralNetwork.setNetwork(network);
			neuralNetwork.run();
			num++;
		}
		network.setInput(Matrix.unit(1, 10d)); // 2289.87
		neuralNetwork.setNetwork(network);
		neuralNetwork.forword();
		System.out.println(neuralNetwork.getOutput());
	}

	private Level initFirstLevel() {
		double[][] weightData = { { -0.27 }, { -0.41 }};
		double[][] biasData = { { -0.48 }, { -0.13 } };
		Matrix weight = new Matrix(weightData);
		Matrix bias = new Matrix(biasData);
		Logsig logsig = new Logsig();
		Level level = new Level(weight, bias, logsig);
		return level;
	}

	private Level initSecondLevel() {
		double[][] weightSecondData = { { 0.09, -0.17 } };
		double[][] biasSecondData = { { 0.48 } };
		Matrix weightSecond = new Matrix(weightSecondData);
		Matrix biasSecond = new Matrix(biasSecondData);
		Level secondLevel = new Level(weightSecond, biasSecond, new Purelin());
		return secondLevel;
	}

	private Network initNetwork() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		Matrix input = Matrix.unit(1, 1.0d);
		Matrix initResult = Matrix.unit(1, 1.707d);
		Network network = new MultiNetwork(input, initResult);
		network.add(first);
		network.add(last);
		return network;
	}

	private NeuralNetwork initNeuralNetwork() {
		Level first = initFirstLevel();
		Level last = initSecondLevel();
		Matrix input = Matrix.unit(1, 1.0d);
		Matrix initResult = Matrix.unit(1, 1.707d);
		Network network = new MultiNetwork(input, initResult);
		network.add(first);
		network.add(last);
		NeuralNetwork neuralNetwork = new NeuralNetwork(network, new BackPropagationRule(last));
		return neuralNetwork;
	}

	@Autowired
	public void setDataMapper(DataMapper dataMapper) {
		this.dataMapper = dataMapper;
	}

	@Autowired
	public void setResultDataMapper(ResultDataMapper resultDataMapper) {
		this.resultDataMapper = resultDataMapper;
	}
}
