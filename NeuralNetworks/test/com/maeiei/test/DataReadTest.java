package com.maeiei.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.maeiei.dao.DataMapper;
import com.maeiei.model.Data;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring.xml" })
public class DataReadTest {

	@Resource(name = "dataMapper")
	private DataMapper dataMapper;

	@Test
	@Ignore
	public void testInsert() {
		Data date = new Data();
		date.setStockId(99);
		date.setId(99);
		date.setOpen(99);
		date.setHigh(99);
		date.setLow(99);
		date.setClose(99);
		date.setMoney(9999);
		date.setStockDate(new Date());
		dataMapper.insert(date);
	}

	@Test
	public void testRead() {
		List<Data> list = dataMapper.selectByCriteria(null);
		assertThat("插入的预算版本个数", list.size(), is(200));
		System.out.println(list);
	}

	@Autowired
	public void setDataMapper(DataMapper dataMapper) {
		this.dataMapper = dataMapper;
	}
}
