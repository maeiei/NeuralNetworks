package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.maeiei.dao.DataMapper;
import com.maeiei.dao.ResultDataMapper;
import com.maeiei.model.Data;
import com.maeiei.model.ResultData;
import com.maeiei.model.ResultDataCriteria;
import com.maeiei.model.ResultDataCriteria.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring.xml" })
public class DataReadTest {

	@Resource(name = "dataMapper")
	private DataMapper dataMapper;

	@Resource(name = "resultDataMapper")
	private ResultDataMapper resultDataMapper;

	@Test
	public void testInsert() {
		ResultData date = new ResultData();
		date.setStockId(99);
		date.setId(99);
		date.setOpen(99);
		date.setHigh(99);
		date.setLow(99);
		date.setClose(99);
		date.setMoney(9999);
		date.setStockDate(new Date());
		int insertNum = resultDataMapper.insert(date);
		assertThat("插入的个数", insertNum, is(1));
		
		ResultDataCriteria criterias = new ResultDataCriteria();
		Criteria criteria = criterias.createCriteria();
		criteria.andIdEqualTo(99);
		criteria.andStockIdEqualTo(99);
		
		resultDataMapper.deleteByCriteria(criterias);
	}

	@Test
	public void testRead() {
		List<Data> list = dataMapper.selectByCriteria(null);
		assertThat("查询个数", list.size(), is(200));
		for (Data d : list)
			System.out.println(d.getOpen());
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
