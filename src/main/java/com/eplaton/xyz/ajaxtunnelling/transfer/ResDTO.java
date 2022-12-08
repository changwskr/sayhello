package com.eplaton.xyz.ajaxtunnelling.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResDTO<K> {
	private int statusCode;
	private K outdata;
	
}

