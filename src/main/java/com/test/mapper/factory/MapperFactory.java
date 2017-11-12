package com.test.mapper.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.bean.Bean;
import com.test.bean.SimpleBean;
import com.test.dto.Dto;
import com.test.dto.SimpleDto;
import com.test.mapper.GlobalMapper;
import com.test.mapper.SimpleMapper;

import fr.xebia.extras.selma.Selma;

public class MapperFactory {

	
	private static Map<GlobalMapperKey,GlobalMapper> mapper = instance();
	
	
	private static List<Class<?>> getMapper() {
		List<Class<?> > mappersClazz = new ArrayList();
		Class<? extends GlobalMapper> clazz = SimpleMapper.class;
		mappersClazz.add(clazz);
		return mappersClazz;
	}
	
	private static Map<GlobalMapperKey, GlobalMapper> instance() {
		for(Class<?> mapper : getMapper()) {
			MapperFactory.mapper.add((GlobalMapper) Selma.builder(mapper).build());
		}
		return mapper ;
	}
	
	private static static<DTO extends Dto, BEAN extends Bean> GlobalMapper resolveMapper(BEAN input,DTO output) {
		
	}
	
	
	
	public static<DTO extends Dto, BEAN extends Bean>  DTO map(BEAN input,DTO output) {
		return  (DTO) resolveMapper().map(input);
	}
}
