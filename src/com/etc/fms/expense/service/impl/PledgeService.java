package com.etc.fms.expense.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.fms.expense.dao.PledgeMapper;
import com.etc.fms.expense.entity.Pledge;
import com.etc.fms.expense.service.IPledgeService;
@Service(value="pledgeservice")
public class PledgeService implements IPledgeService {

	//×¢Èëdao
	@Resource(name="pledgedao")
	public PledgeMapper pledgedao;
	
	
	public PledgeMapper getPledgedao() {
		return pledgedao;
	}


	public void setPledgedao(PledgeMapper pledgedao) {
		this.pledgedao = pledgedao;
	}


	@Override
	public boolean addPledge(Pledge pledge) {
		// TODO Auto-generated method stub
		boolean flag=pledgedao.insert1(pledge);
		
		
		return flag;
	}

}
