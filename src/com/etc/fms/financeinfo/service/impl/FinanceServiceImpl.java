package com.etc.fms.financeinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.fms.financeinfo.dao.FinanceInfoMapper;
import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;
import com.etc.fms.financeinfo.service.IFinanceService;

@Service(value = "financeinfoService")
public class FinanceServiceImpl implements IFinanceService {

	/**
	 * ע��
	 */
	@Resource(name = "financeinfodao")
	private FinanceInfoMapper financeinfodao;
	
	public FinanceInfoMapper getFinanceinfodao() {
		return financeinfodao;
	}

	public void setFinanceinfodao(FinanceInfoMapper financeinfodao) {
		this.financeinfodao = financeinfodao;
	}

	@Override
	public int delFinanceinfo(int fid)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delFinanceinfos(int cid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FBaoBiao> getFinanceBBlist(int cid, String begintime,
			String endtime)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinanceInfo getFinanceinfo(String cno)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinanceInfo> getFinanceinfolist(int cid, String begintime,
			String endtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveFinanceinfo(FinanceInfo f)  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFinance(FinanceInfo f)  {
		// TODO Auto-generated method stub
		return 0;
	}

}
