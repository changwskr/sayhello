package com.eplaton.xyz.ajaxtunnelling.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.xyz.ajaxtunnelling.business.repository.dao.AjaxUserRepository;
import com.eplaton.xyz.ajaxtunnelling.transfer.InDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.OutDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.ResDTO;

@RestController
public class TPSrecvController {

	private AjaxUserRepository userRepository;

	// DI = 의존성 주입
	public TPSrecvController(AjaxUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@CrossOrigin
	@PostMapping("/tpsrecv")
	public ResDTO<OutDto> serviceFacade(@RequestBody InDto inDto) {

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

}
