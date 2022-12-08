package com.eplaton.xyz.ajaxtunnelling.business.repository.dao;

import org.springframework.stereotype.Repository;

import com.eplaton.xyz.ajaxtunnelling.business.service.BTF;
import com.eplaton.xyz.ajaxtunnelling.business.service.ETF_SPcommon;
import com.eplaton.xyz.ajaxtunnelling.business.service.STF_SPcommon;
import com.eplaton.xyz.ajaxtunnelling.transfer.InDto;
import com.eplaton.xyz.ajaxtunnelling.transfer.OutDto;

// Repository는 Root Context가 기동해준다.
@Repository
public class AjaxEplatonRepository {

	BTF btf = new BTF();
	STF_SPcommon stf = new STF_SPcommon();
	ETF_SPcommon etf = new ETF_SPcommon();
	InDto inDto = new InDto();
	OutDto outDto = new OutDto();

	public InDto getInDto() {

		return this.inDto;
	}

	public OutDto getOutDto() {

		return this.outDto;
	}

	public BTF getBTF() {
		return this.btf;
	}

	public STF_SPcommon getSTF_SPcommon() {
		return this.stf;
	}

	public ETF_SPcommon getETF_SPcommon() {
		return this.etf;
	}

}
