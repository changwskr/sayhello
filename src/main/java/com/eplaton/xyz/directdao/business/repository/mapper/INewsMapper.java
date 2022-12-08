package com.eplaton.xyz.directdao.business.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eplaton.xyz.directdao.business.repository.entity.NewsEntity;

@Mapper
public interface INewsMapper {
	public List<NewsEntity> listNews();
}
