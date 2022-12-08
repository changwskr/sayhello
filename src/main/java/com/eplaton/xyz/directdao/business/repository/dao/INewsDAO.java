package com.eplaton.xyz.directdao.business.repository.dao;

import java.util.List;

import com.eplaton.xyz.directdao.business.repository.entity.NewsEntity;

public interface INewsDAO {

	public void insert(NewsEntity newsentity);

	public void update(NewsEntity newsentity);

	public void delete(int id);

	public List<NewsEntity> selectList();

	public List<NewsEntity> listNews();

}
