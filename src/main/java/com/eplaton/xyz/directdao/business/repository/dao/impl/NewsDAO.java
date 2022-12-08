package com.eplaton.xyz.directdao.business.repository.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eplaton.xyz.directdao.business.repository.dao.INewsDAO;
import com.eplaton.xyz.directdao.business.repository.entity.NewsEntity;
import com.eplaton.xyz.directdao.business.repository.mapper.INewsMapper;

@Service
@Transactional
public class NewsDAO implements INewsDAO {

	@Autowired
	private INewsMapper newsMapper;

	@Autowired
	public NewsDAO(INewsMapper newsMapper) {
		super();
		this.newsMapper = newsMapper;
	}

	public void insert(NewsEntity newsentity) {
		System.out.println("newsentity insert post" + newsentity);
		// newsMapper.insert(newsentity);
	}

	public void update(NewsEntity newsentity) {
		System.out.println("news update post" + newsentity);
		// newsMapper.update(newsentity);
	}

	public void delete(int id) {
		System.out.println("news delete post--" + id);
		// newsMapper.delete(id);
	}

	public List<NewsEntity> selectList() {
		System.out.println("news selectlist ");
		return newsMapper.listNews();
	}

	public List<NewsEntity> listNews() {
		System.out.println("news selectlist ");
		return newsMapper.listNews();
	}

}
