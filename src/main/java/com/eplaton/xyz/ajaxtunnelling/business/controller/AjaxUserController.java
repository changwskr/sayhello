package com.eplaton.xyz.ajaxtunnelling.business.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.xyz.ajaxtunnelling.business.repository.dao.AjaxUserRepository;
import com.eplaton.xyz.ajaxtunnelling.business.repository.entity.User;
import com.eplaton.xyz.ajaxtunnelling.transfer.CommonDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.InDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.JoinReqDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.OutDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.ReqCommonDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.ResDTO;
import com.eplaton.xyz.ajaxtunnelling.transfer.ResonseDTO;
import com.eplaton.xyz.ajaxtunnelling.transfer.UpdateReqDto;

@RestController
public class AjaxUserController {

	private AjaxUserRepository userRepository;

	// DI = 의존성 주입
	public AjaxUserController(AjaxUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// http://localhost:8080/ajaxtunnelling/user
	@GetMapping("/ajaxtunnelling/user")
	public CommonDto<List<User>> findAll() {
		System.out.println("findAll()");
		return new CommonDto<>(HttpStatus.OK.value(), userRepository.findAll()); // MessageConverter (JavaObject -> Json
																					// String)
	}

	// http://localhost:8080/ajaxtunnelling/ajaxtunnelling/user/2
	// http://localhost:8080/ajaxtunnelling/ajaxtunnelling/user/1
	@GetMapping("/ajaxtunnelling/user/{id}")
	public CommonDto<User> findById(@PathVariable int id) {
		System.out.println("findById() : id : " + id);
		return new CommonDto<>(HttpStatus.OK.value(), userRepository.findById(id));
	}

	@CrossOrigin
	// http://localhost:8080/ajaxtunnelling/user
	@PostMapping("/ajaxtunnelling/user")
	// x-www-form-urlencoded => request.getParamter()
	// text/plain => @RequestBody 어노테이션
	// application/json => @ResponseBody 어노테이션 + 오브젝트로 받기
	public CommonDto<?> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {

		System.out.println("save()");
		System.out.println("user : " + dto);
		userRepository.save(dto);

//		System.out.println("data : "+data);
//		System.out.println("username : "+username);
//		System.out.println("password : "+password);
//		System.out.println("phone : "+phone);

		return new CommonDto<>(HttpStatus.CREATED.value(), "ok");
	}

	// http://localhost:8080/ajaxtunnelling/user/2
	@DeleteMapping("/ajaxtunnelling/user/{id}")
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete()");
		userRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value());
	}

	// http://localhost:8080/ajaxtunnelling/user/2
	@PutMapping("/ajaxtunnelling/user/{id}")
	public CommonDto update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {

		System.out.println("update()");
		userRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value());
	}

	// ==================================================================

	// http://localhost:8080/ajaxtunnelling/usergo
	@GetMapping("/ajaxtunnelling/usergo")
	public List<User> findAllGo() {

		/*
		 * 1번 본래 JSP 스타일
		 */
		AjaxUserRepository userRepository = new AjaxUserRepository();
		userRepository.findAll();

		/*
		 * 2번 스타일 IOC 컨테이너 활용 이미 Controller 생성시 DI=의존성 주입이 완료 되어 있다.
		 */
		List<User> li = this.userRepository.findAll(); // MessageConverter 가 등장한다. => 그래서 User Java Object를 JSON
														// String으로 변환한다.

		System.out.println("findAllGo()");

		return li;

	}

	// http://localhost:8080/ajaxtunnelling/usergo/2
	// http://localhost:8080/ajaxtunnelling/usergo/1
	@GetMapping("/ajaxtunnelling/usergo/{id}")
	public void findByIdGo(@PathVariable int id) {
		System.out.println("findById() : id : " + id);

	}

	@GetMapping("/ajaxtunnelling/usergo/{id}/{name}")
	public String findByIdGo(@PathVariable int id, @PathVariable String name) {
		System.out.println("findById() : id : " + id + "," + name);
		return id + "," + name;

	}

	@GetMapping("/ajaxtunnelling/usergogo/{id}")
	public User findByIdGogo(@PathVariable int id) {
		System.out.println("findById() : id : " + id);
		return new User(id, "jws", "aaaa", "1111");
	}

	@GetMapping("/ajaxtunnelling/usergogogo/{id}")
	public User findByIdGogogo(@PathVariable int id) {
		System.out.println("findById() : id : " + id);
		return this.userRepository.findById(id); // Repository에 DI 된 객체를 리턴한다.
	}

	// http://localhost:8080/ajaxtunnelling/usergo
	// x-www-form-urlencoded 로 파싱해서 처리한다. 왜냐 save1의 파라미터가 객체가 아니고 일반변수 타입이기 때문에 스프링은
	// form 타입이라 간주한다.
	// x-www-form-urlencoded => request.getParameter() 과 같다는 의미이다.
	// 올라온 객체를 찾는다. 무엇을 여기서는 username, password, phone을 찾아서 파라미터에 주입한다.
	@PostMapping("/ajaxtunnelling/usergo")
	public void saveGo(String username, String password, String phone, String email) {
		System.out.println("saveGo11()" + username + password + phone);
	}

	// text/plain 을 받지 못하는 상황이 위에서 발생할 것인데 이것을 받게 만들려면
	// text/plain => @RequestBody 어노테이션을 통해서 받는다.
	// (String username, String password, String phone, String email) 을 @RequestBody
	// String data 로변경한다.
	@PostMapping("/ajaxtunnelling/usergobody")
	public void saveGobody(@RequestBody String data) {
		System.out.println("saveGogobody()" + data);
	}

	// 스트링을 받지않고 오브넥트 받는 다면 어떻게 할까
	@PostMapping("/ajaxtunnelling/usergoobject")
	public void saveGoobject(@RequestBody User user) {
		System.out.println("saveGogoobject()" + user);
		// this.userRepository.save(user);

	}

	// 응답모델 -- DTO를 생성해서 클라이언트로 전송한다.
	// 여기서는 응답이 만약 문자열이면 String을 리턴한다.
	// ResponseEntity<T> => ResponseEntity<String>
	@PostMapping("/ajaxtunnelling/usergoobjectres")
	public ResponseEntity<String> saveGoobjectres(@RequestBody User user) {
		System.out.println("saveGogoobject()" + user);
		this.userRepository.save(user);

		// return new ResponseEntity<>("ok",HttpStatus.OK);
		return new ResponseEntity<>("당신은 권한이 없습니다.", HttpStatus.FORBIDDEN);
	}

	// 만약 현재 로직을 외부에서도 호출가능하게 할려면
	// CrossOrigin 어노테이션을 기술한다.
	@CrossOrigin
	@PostMapping("/ajaxtunnelling/usergoobjectpermit")
	public ResponseEntity<String> saveGoobjectpermit(@RequestBody User user) {
		System.out.println("saveGogoobject()" + user);
		this.userRepository.save(user);

		// return new ResponseEntity<>("ok",HttpStatus.OK);
		return new ResponseEntity<>("당신은 권한이 없습니다.", HttpStatus.FORBIDDEN);

	}

	// 만약 현재 로직을 외부에서도 호출가능하게 할려면
	// CrossOrigin 어노테이션을 기술한다.
	@CrossOrigin
	@PostMapping("/ajaxtunnelling/usergoobjectpermit2")
	public ResponseEntity<ReqCommonDto<String>> saveGoobjectpermit2(@RequestBody User user) {
		System.out.println("saveGogoobject()" + user);
		this.userRepository.save(user);
		return new ResponseEntity<>(new ReqCommonDto<>(200, "OK"), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/ajaxtunnelling/usergoobjectpermit3")
	public ReqCommonDto<String> saveGoobjectpermit3(@RequestBody User user) {
		System.out.println("saveGogoobject()" + user);
		this.userRepository.save(user);
		return new ReqCommonDto<>(HttpStatus.OK.value(), "OK");
	}

	// ---------------------
	@CrossOrigin
	@PostMapping("/ajaxtunnelling/userjoin")
	public ReqCommonDto<String> savejoin(@RequestBody JoinReqDto dto) {
		System.out.println("savejoin()" + dto);
		this.userRepository.save(dto);
		return new ReqCommonDto<>(HttpStatus.OK.value(), "OK");
	}

	// -----------------------

	@CrossOrigin
	@PostMapping("/request")
	public ResonseDTO<InDto, OutDto> request(@RequestBody InDto inDto) {
		System.out.println("request()" + inDto);

		OutDto outDto = new OutDto();
		outDto.setGuid(inDto.getGuid());
		outDto.setIndata(inDto.getIndata());
		outDto.setOutdata("uuuu kkkk uuuu aaa");
		outDto.setOuttime("1010111");

		return new ResonseDTO<>(HttpStatus.OK.value(), inDto, outDto);
	}

	@CrossOrigin
	@PostMapping("/clireq")
	public ResDTO<OutDto> cliereq(@RequestBody InDto inDto) {

		System.out.println("------------client recv");
		System.out.println("clireq()" + inDto);

		inDto.setGuid("99999");

		OutDto outDto = new OutDto();
		outDto.setUserid(inDto.getUserid());
		outDto.setTxcode(inDto.getTxcode());
		outDto.setGuid(inDto.getGuid());
		outDto.setIndata(inDto.getIndata());
		outDto.setOutdata("uuuu kkkk uuuu aaa");
		outDto.setOuttime("1010111");

		System.out.println("---------------stf start");
		System.out.println("---------------stf end");

		System.out.println("---------------btf start");
		System.out.println("---------------btf end");

		System.out.println("---------------etf start");
		System.out.println("---------------etf end");

		System.out.println("---------------client send");

		return new ResDTO<>(HttpStatus.OK.value(), outDto);
	}

	@GetMapping("/ajaxtunnelling/userttt/{id}")
	public ReqCommonDto<User> findByIdgogogo(@PathVariable int id) {
		System.out.println("findById() : id : " + id);
		return new ReqCommonDto<User>(HttpStatus.OK.value(), userRepository.findById(id));
	}

	// http://localhost:8080/ajaxtunnelling/usergo
	@GetMapping("/ajaxtunnelling/usergottt")
	public ReqCommonDto<List<User>> findAllGottt() {
		List<User> li = this.userRepository.findAll(); // MessageConverter 가 등장한다. => 그래서 User Java Object를 JSON
														// String으로 변환한다.

		System.out.println("findAllGo()");

		return new ReqCommonDto<>(HttpStatus.OK.value(), userRepository.findAll());

	}

	// @PathVariable 은 {id} 다이나믹한 정보를 가져온다는 선언이다.
	// http://localhost:8080/ajaxtunnelling/usergo/2
	@DeleteMapping("/ajaxtunnelling/usergottt/{id}")
	public ReqCommonDto<String> deleteGo(@PathVariable int id) {

		System.out.println("데이타 베이스의 데이타를 삭제합니다.");
		int rtn = userRepository.delete(id);
		if (rtn == 0) {
			return new ReqCommonDto<String>(HttpStatus.OK.value(), null);
		} else {
			return new ReqCommonDto<String>(HttpStatus.FAILED_DEPENDENCY.value(), null);
		}
	}

	@PutMapping("/ajaxtunnelling/usergo/{id}")
	public void putGo(@PathVariable int id, String password, String phone) {
		System.out.println("putGo()");

	}

	@PutMapping("/ajaxtunnelling/usergottt/{id}")
	public void putGottt(@PathVariable int id, @RequestBody User user) {
		System.out.println("putGo()");

	}

	@PutMapping("/ajaxtunnelling/usergo01/{id}")
	public void update(@PathVariable int id, @RequestBody UpdateReqDto dto) {
		System.out.println("putGo()" + dto);
		userRepository.update(id, dto);

	}

	@PutMapping("/ajaxtunnelling/usergo02/{id}")
	public ReqCommonDto update01(@PathVariable int id, @RequestBody UpdateReqDto dto) {
		System.out.println("putGo()" + dto);
		userRepository.update(id, dto);

		// userRepository.update에서 현재는 강제적으로 예외를 발생시켜서 로직이 예외에서 끝남
		// 따라서 하위 처리는 하지 않는다.
		return new ReqCommonDto<>(HttpStatus.OK.value(), userRepository);
	}

	@DeleteMapping("/ajaxtunnelling/usergo/{id}")
	public void deleteGo(@PathVariable int id, String password, String phone) {
		System.out.println("deleteGo()");

	}

}
