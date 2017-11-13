package com.test.mapper;

import com.test.bean.Bean;
import com.test.dto.Dto;

public interface GlobalMapper<BEAN extends Bean,DTO extends Dto> {

 DTO  map(BEAN  bean);

}
