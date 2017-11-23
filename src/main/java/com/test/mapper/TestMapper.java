package com.test.mapper;

import com.test.bean.SimpleBean;
import com.test.dto.SimpleDto;

import fr.xebia.extras.selma.Mapper;

@Mapper
public interface TestMapper extends GlobalMapper<SimpleBean, SimpleDto> {

}
