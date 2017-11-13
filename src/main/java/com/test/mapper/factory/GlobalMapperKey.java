package com.test.mapper.factory;

import com.test.bean.Bean;
import com.test.dto.Dto;

public class GlobalMapperKey {

	private Class<? extends Bean> beanClazz;
	private Class<? extends Dto> dtoClazz;

	public Class<? extends Bean> getBeanClazz() {
		return beanClazz;
	}

	public void setBeanClazz(Class<? extends Bean> beanClazz) {
		this.beanClazz = beanClazz;
	}

	public Class<? extends Dto> getDtoClazz() {
		return dtoClazz;
	}

	public void setDtoClazz(Class<? extends Dto> dtoClazz) {
		this.dtoClazz = dtoClazz;
	}

	public boolean isMapper(Class<? extends Bean> beanClass, Class<? extends Dto> dtoClazz) {
		return beanClass.equals(getBeanClazz()) && dtoClazz.equals(getDtoClazz()) || dtoClazz.equals(getBeanClazz()) && beanClass.equals(getDtoClazz()) ;
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GlobalMapperKey [beanClazz=").append(beanClazz).append(", dtoClazz=").append(dtoClazz)
				.append("]");
		return builder.toString();
	}

	
}
