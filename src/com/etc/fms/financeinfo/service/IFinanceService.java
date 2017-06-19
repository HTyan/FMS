package com.etc.fms.financeinfo.service;

import java.util.List;

import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;

public interface IFinanceService { //
	public int saveFinanceinfo(FinanceInfo f) throws Exception;

	public FinanceInfo getFinanceinfo(String cno) throws Exception;

	public List<FinanceInfo> getFinanceinfolist(int cid, String begintime,
			String endtime) throws Exception;
	
	public List<FBaoBiao> getFinanceBBlist(int cid, String begintime,
			String endtime) throws Exception; //±¨±í

	public int delFinanceinfos(int cid) throws Exception;
	
	public int delFinanceinfo(int fid) throws Exception;
	
	public int updateFinance(FinanceInfo f) throws Exception;
}
