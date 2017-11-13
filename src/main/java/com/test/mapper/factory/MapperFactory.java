package com.test.mapper.factory;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.bean.Bean;
import com.test.dto.Dto;
import com.test.mapper.GlobalMapper;
import com.test.mapper.SecondSimpleMapper;
import com.test.mapper.SimpleMapper;

import fr.xebia.extras.selma.Selma;

public class MapperFactory {

	private static Map<GlobalMapperKey, GlobalMapper> mapper = instance();

	private static List<Class<?>> getMapper() {
		List<Class<?>> mappersClazz = new ArrayList();
		Class<? extends GlobalMapper> clazz = SimpleMapper.class;
		Class<? extends GlobalMapper> clazzB = SecondSimpleMapper.class;
		mappersClazz.add(clazzB);
		mappersClazz.add(clazz);
		return mappersClazz;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map<GlobalMapperKey, GlobalMapper> instance() {
		mapper = new HashMap<GlobalMapperKey, GlobalMapper>();
		for (Class<?> mapper : getMapper()) {
			GlobalMapperKey key = new GlobalMapperKey();
			Class clazz = (Class) ((ParameterizedType) mapper.getGenericInterfaces()[0]).getActualTypeArguments()[0];
			key.setBeanClazz(clazz);
			Class clazzb = (Class) ((ParameterizedType) mapper.getGenericInterfaces()[0]).getActualTypeArguments()[1];
			key.setDtoClazz(clazzb);
			MapperFactory.mapper.put(key, (GlobalMapper) Selma.builder(mapper).build());
		}
		return mapper;
	}

	private static <DTO extends Dto, BEAN extends Bean> GlobalMapper resolveMapper(BEAN input, DTO output) {

		GlobalMapper mapper = null;
		for (GlobalMapperKey key : MapperFactory.mapper.keySet()) {
			if (key.isMapper(input.getClass(), output.getClass())) {
				mapper = MapperFactory.mapper.get(key);
			}
		}
		return mapper;

	}

	public static <DTO extends Dto, BEAN extends Bean> DTO map(BEAN input, DTO output) {
		return (DTO) resolveMapper(input, output).map(input);
	}
}
