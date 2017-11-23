package com.test.mapper;

import com.test.bean.AnotherSimpleBean;
import com.test.dto.AnotherSimpleDto;

import fr.xebia.extras.selma.Mapper;
@Mapper
public interface SecondSimpleMapper extends GlobalMapper<AnotherSimpleBean, AnotherSimpleDto> {

	
}
