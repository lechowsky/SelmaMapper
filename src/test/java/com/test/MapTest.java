package com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.test.bean.SimpleBean;
import com.test.dto.SimpleDto;
import com.test.mapper.SimpleMapper;
import com.test.mapper.factory.MapperFactory;

import sun.java2d.pipe.SpanShapeRenderer.Simple;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(BlockJUnit4ClassRunner.class)
public class MapTest {
	
	private static PodamFactory podamFactory;

	private SimpleMapper mapper;
	
	@BeforeClass
	public static void intStatic() {
		podamFactory =  new PodamFactoryImpl();
	}

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void simpleMapTest(){
		SimpleBean bean = podamFactory.manufacturePojo(SimpleBean.class);
		
		SimpleDto result  = MapperFactory.map(bean);
		Assert.assertNotNull(result);
		Assert.assertEquals(bean.getStringField(), result.getStringField());
		Assert.assertEquals(bean.getId(), result.getId());
	}

}
