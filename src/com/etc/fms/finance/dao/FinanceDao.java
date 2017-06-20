package com.etc.fms.finance.dao;

import java.util.List;

import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;

public interface FinanceDao { //
	public int saveFinanceInfo(FinanceInfo f) throws Exception;

	public FinanceInfo getFinanceInfo(String cno) throws Exception;

	public List<FinanceInfo> getFinanceInfolist(int cid, String begintime,
			String endtime) throws Exception;
	
	public List<FBaoBiao> getFinanceBBlist(int cid, String begintime,
			String endtime) throws Exception; //±¨±í

	public int delFinanceInfos(int cid) throws Exception;
	
	public int delFinanceInfo(int fid) throws Exception;
	
	public int updateFinance(FinanceInfo f) throws Exception;
}
