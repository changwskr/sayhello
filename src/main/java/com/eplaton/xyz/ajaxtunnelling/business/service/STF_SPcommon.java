package com.eplaton.xyz.ajaxtunnelling.business.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.eplaton.xyz.ajaxtunnelling.transfer.InDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.OutDto;

public class STF_SPcommon {

	public static void baseinfo(InDto inDto, OutDto outDto) {

		inDto.setGuid("201015091011001");
		inDto.setOuttime("11101199");
		inDto.setIndate("20101015");
		inDto.setOutdate("20101015");

		outDto.setIntime(inDto.getIntime());
		outDto.setUserid(inDto.getUserid());
		outDto.setTxcode(inDto.getTxcode());
		outDto.setGuid(inDto.getGuid());
		outDto.setIndata(inDto.getIndata());

	}

	public static int valid(BindingResult bindingResult, OutDto outDto) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();

			// bindingResult.getFieldErrors()는 콜렉션을 리턴하므로 error는 이 리턴된 콜렉션 만큼 돈다.
			// List<FieldError> org.springframework.validation.Errors.getFieldErrors()
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("-->" + error.getDefaultMessage());
			}
			outDto.setErrorMap(errorMap);
			return (-1);
		}
		return (0);
	}

}
