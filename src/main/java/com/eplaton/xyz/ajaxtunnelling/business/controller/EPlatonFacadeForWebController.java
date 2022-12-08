package com.eplaton.xyz.ajaxtunnelling.business.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.xyz.ajaxtunnelling.business.repository.dao.AjaxEplatonRepository;
import com.eplaton.xyz.ajaxtunnelling.business.service.BTF;
import com.eplaton.xyz.ajaxtunnelling.business.service.ETF_SPcommon;
import com.eplaton.xyz.ajaxtunnelling.business.service.STF_SPcommon;
import com.eplaton.xyz.ajaxtunnelling.transfer.InDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.OutDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.ResDTO;
import com.eplaton.xyz.ajaxtunnelling.business.repository.dao.AjaxUserRepository;

//http://localhost:8080/person/eplatonFacadeWeb
//전송 json 오브젝트
//{
//	"userid": "jws",
//    "txcode": "9999",
//    "intime": "101011",
//    "outtime": "1010111",
//    "guid": "99999",
//    "indata": "sssssssssssssss"
//}

@RestController
public class EPlatonFacadeForWebController {

	private static final Logger log = LoggerFactory.getLogger(EPlatonFacadeForWebController.class);
	private AjaxUserRepository userRepository;
	private AjaxEplatonRepository epltonRepository;
	private BTF btf;
	private STF_SPcommon stf;
	private ETF_SPcommon etf;
	private InDto oinDto;
	private OutDto outDto;

	// DI = 의존성 주입
	public EPlatonFacadeForWebController(AjaxEplatonRepository epltonRepository) {
		this.epltonRepository = epltonRepository;
		this.btf = epltonRepository.getBTF();
		this.etf = epltonRepository.getETF_SPcommon();
		this.stf = epltonRepository.getSTF_SPcommon();
		this.oinDto = epltonRepository.getInDto();
		this.outDto = epltonRepository.getOutDto();
	}

	// AOP 작업을 한다.
	// @Valid BindingResult bindResult 추가
	// bindResult 객체에는 사전에 필터걸은 내용들에 대한 결과가 저장된다.
	// 예를 든다면
	// InDto에 다음의 어노테이션을 걸었다.
	// @Size(max = 20, message = "유저네임 길이를 초과하였습니다.")
	// private String username;
	// 여기에 결과가 저장된다는 말이다.

	@CrossOrigin
	@PostMapping("/eplfacade")
	// ResDTO<?> 본래는 ResDTO<OutDto> 이어야 하나 리턴시 무엇을 리턴하는지 모른다면 ? 할수 있다.
	public ResDTO<?> eplatonFacade(@Valid @RequestBody InDto inDto, BindingResult bindingResult) {
		// InDto의 밸리데이션을 체킹해서 bindingResult에 담는다.

		// 로그 레벨 error, warn, info, debug
		log.warn("==========================client recv");
		log.debug("==========================client recv");

		System.out.println("------------client recv");
		System.out.println("clireq()" + inDto);

		System.out.println("---------------stf start");

		oinDto = inDto;
		stf.baseinfo(inDto, outDto);
		System.out.println("clireq-inDto()  " + inDto);
		System.out.println("clireq-oinDto()" + oinDto);
		switch (stf.valid(bindingResult, outDto)) {
		case -1:
			System.out.println("stf error ");
			System.out.println("---------------stf end");
			outDto.setErrcode("ERR1010");
			outDto.setErrmsg("밸리데이션 오류");
			break;
		case 0:
			System.out.println("---------------stf end");
			System.out.println("---------------btf start");
			btf.preProcess(inDto, outDto);
			btf.comService(inDto, outDto);

			btf.postProcess(inDto, outDto);
			System.out.println("---------------btf end");
			break;
		default:
			break;
		}

		System.out.println("---------------etf start");

		etf.baseinfo(outDto);

		System.out.println("---------------etf end");

		System.out.println("------------server send");
		System.out.println(outDto);

		return new ResDTO<>(HttpStatus.OK.value(), outDto);
		// return new ResDTO<>(HttpStatus.BAD_REQUEST.value(), outDto.getErrorMap());
	}

}
