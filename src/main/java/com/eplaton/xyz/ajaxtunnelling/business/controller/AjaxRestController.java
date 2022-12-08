package com.eplaton.xyz.ajaxtunnelling.business.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.xyz.ajaxtunnelling.business.repository.entity.User;

@RestController
public class AjaxRestController {

	@PostMapping(value = "/ajaxtunnelling/welcome")
	public User recvserver(@RequestBody Map<String, Object> postData) {

		User user = new User();

		System.out.println("/ajaxtunnelling/welcome/ start==========2");
		StringBuilder sb = new StringBuilder();

		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
			if (map.getKey() == "username") {
				user.setUsername(map.getValue().toString());
			} else if (map.getKey() == "password") {
				user.setPassword((String) map.getValue().toString());
			}
		});

		System.out.println("전송데이타 내용[" + user + "]");
		System.out.println("/ajaxtunnelling/welcome/ end==========");

		return user;
	}

}
