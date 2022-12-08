package com.eplaton.xyz.ajaxtunnelling.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ReqCommonDto<T> {
	private int statusCode;
	private T data;
	
	public ReqCommonDto(int statusCode) {
		super();
		this.statusCode = statusCode;
	}	
	
	public ReqCommonDto(int statusCode, T data) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}	

	
}
