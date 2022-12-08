package com.eplaton.xyz.ajaxtunnelling.transfer;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutDto {
	private String userid;
	
	@NotNull(message = "유저네임 키값이 없습니다.")
	@NotBlank(message = "유저네임을 입력하세요.")
	@Size(max = 20, message = "유저네임 길이를 초과하였습니다.")
	private String username;

	@NotNull(message = "비밀번호가 없습니다.")
	private String password;

	private String txcode;
	private String indate;
	private String outdate;
	private String errcode;
	private String errmsg;
	private String intime;
	private String outtime;
	private String guid;
	private String indata;	
	private String outdata;
	
	Map<String, String> errorMap;
}

