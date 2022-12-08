package com.eplaton.xyz.directdao.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.xyz.directdao.business.repository.dao.INewsDAO;
import com.eplaton.xyz.directdao.business.repository.entity.NewsEntity;

@RestController
public class NewsControllerDirectDAO {

	private Logger logger = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	private INewsDAO newsdao;

	@RequestMapping("/directdao")
	public @ResponseBody Map<String, Object> news() throws Exception {
		Map<String, Object> rtnObj = new HashMap<>();

		List<NewsEntity> newsList = newsdao.listNews();
		logger.info("news->" + newsList.toString());

		rtnObj.put("news_list", newsList);
		return rtnObj;
	}
}
