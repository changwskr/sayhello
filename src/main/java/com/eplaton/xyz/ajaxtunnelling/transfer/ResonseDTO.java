package com.eplaton.xyz.ajaxtunnelling.transfer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResonseDTO<T , K> {
	private int statusCode;
	private T indata;
	private K outdata;
	
}

