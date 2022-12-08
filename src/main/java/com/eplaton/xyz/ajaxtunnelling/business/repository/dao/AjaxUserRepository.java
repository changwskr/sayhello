package com.eplaton.xyz.ajaxtunnelling.business.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eplaton.xyz.ajaxtunnelling.business.repository.entity.User;
import com.eplaton.xyz.ajaxtunnelling.transfer.JoinReqDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.UpdateReqDto;

// Repository는 Root Context가 기동해준다.
@Repository
public class AjaxUserRepository {

	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "ssar", "1234", "0102222"));
		users.add(new User(2, "cos", "1234", "0102222"));
		users.add(new User(3, "love", "1234", "0102222"));
		return users;
	}

	public User findById(int id) {
		return new User(id, "ssar", "1234", "0102222");
	}

	public void save(JoinReqDto dto) {
		System.out.println("DB에 insert하기");
	}

	public void save(User dto) {
		System.out.println("DB에 insert하기");
	}

	public int delete(int id) {
		System.out.println("DB에 삭제하기");
		return 0;
	}

	public void update(int id, UpdateReqDto dto) {
		// DAO연결해서 실행하다가 예외 터짐
		System.out.println("--update----1111");
		throw new IllegalArgumentException("아규먼트를 잘못 넣음");
		// System.out.println("--update----222");
		// System.out.println("DB에 수정하기");
	}

	// 예외 상황을 위한 코드 작성
	// 코드에서 난 예외를 프레임차원에서 낙아 채어서 처리한다.
	// 이게 뭐냐 RestController
	// 실제 구현은 MyExceptionHandler를 보면됨
	// MyExceptionHandler 여기서 Exception에 대한 처리를 프레임워크 차원에서 진행함

	// =======================================================
	public List<User> findAllGo() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "ssar", "1234", "0102222"));
		users.add(new User(2, "cos", "1234", "0102222"));
		users.add(new User(3, "love", "1234", "0102222"));
		return users;
	}

}
