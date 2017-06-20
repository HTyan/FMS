package com.etc.fms.finance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.fms.finance.conn.util.ConnectionUtil;
import com.etc.fms.finance.dao.FinanceDao;
import com.etc.fms.financeinfo.entity.FBaoBiao;
import com.etc.fms.financeinfo.entity.FinanceInfo;

public class FinanceDaoImpl implements FinanceDao {

	private ConnectionUtil cu = null;

	public FinanceDaoImpl() {
		this.cu = new ConnectionUtil();
		this.cu.open();
	}

	public int delFinanceInfos(int cid) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("delete from finance.financeinfo where cid=?");
		ps.setInt(1, cid);
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public int delFinanceInfo(int fid) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("delete from finance.financeinfo where fid=?");
		ps.setInt(1, fid);
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public FinanceInfo getFinanceInfo(String cno) throws Exception {
		String sql = "select fid,cid,cno,fname,yishou,sishou,ftime, ytime,des from finance.financeinfo where cno='"
				+ cno + "'";
		ResultSet rs = cu.executeQuery(sql);
		FinanceInfo f = null;
		while (rs.next()) {
			f = new FinanceInfo();
			f.setFid(rs.getInt("fid"));
			f.setCid(rs.getInt("cid"));
			f.setCno(rs.getString("cno"));
			f.setFname(rs.getString("fname"));
			f.setYishou(rs.getDouble("yishou"));
			f.setSishou(rs.getDouble("sishou"));
			f.setFtime(rs.getString("ftime"));
			f.setYtime(rs.getString("ytime"));
			f.setDes(rs.getString("des"));
		}
		cu.close(rs);
		cu.close();
		return f;
	}

	public List<FinanceInfo> getFinanceInfolist(int cid, String begintime,
			String endtime) throws Exception {
		String sql = "select fid,cid,cno,fname,yishou,sishou,ftime, ytime,des from finance.financeinfo where 1=1 ";
		if (cid > 0) {
			sql += "and cid=" + cid;
		}
		if (begintime != null && begintime.trim().length() > 0) {
			sql += "and ftime >= '" + begintime + "'";
		}
		if (endtime != null && endtime.trim().length() > 0) {
			sql += "and ftime <= '" + endtime + "'";
		}
		sql += " order by ytime desc";
		ResultSet rs = cu.executeQuery(sql);
		List<FinanceInfo> list = new ArrayList<FinanceInfo>();
		while (rs.next()) {
			FinanceInfo f = new FinanceInfo();
			f.setFid(rs.getInt("fid"));
			f.setCid(rs.getInt("cid"));
			f.setCno(rs.getString("cno"));
			f.setFname(rs.getString("fname"));
			f.setYishou(rs.getDouble("yishou"));
			f.setSishou(rs.getDouble("sishou"));
			f.setFtime(rs.getString("ftime"));
			f.setYtime(rs.getString("ytime"));
			f.setDes(rs.getString("des"));
			list.add(f);
		}
		cu.close(rs);
		cu.close();
		return list;
	}

	public List<FBaoBiao> getFinanceBBlist(int cid, String begintime,
			String endtime) throws Exception {

		String sql = "select cid,sum(yishou) ys,sum(sishou) sh from finance.financeinfo where 1=1 ";
		if (cid > 0) {
			sql += "and cid=" + cid;
		}
		if (begintime != null && begintime.trim().length() > 0) {
			sql += "and ftime >= '" + begintime + "'";
		}
		if (endtime != null && endtime.trim().length() > 0) {
			sql += "and ftime <= '" + endtime + "'";
		}
		sql += " group by cid";
		ResultSet rs = cu.executeQuery(sql);
		List<FBaoBiao> list = new ArrayList<FBaoBiao>();
		while (rs.next()) {
			FBaoBiao f = new FBaoBiao();
			f.setCid(rs.getInt("cid"));
			f.setYs(rs.getDouble("ys"));
			f.setSh(rs.getDouble("sh"));
			list.add(f);
		}
		cu.close(rs);
		cu.close();
		return list;
	}

	public int saveFinanceInfo(FinanceInfo u) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("insert into finance.financeinfo(cid,cno,fname,yishou,sishou,ftime,ytime,des)values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, u.getCid());
		ps.setString(2, u.getCno());
		ps.setString(3, u.getFname());
		ps.setDouble(4, u.getYishou());
		ps.setDouble(5, u.getSishou());
		ps.setString(6, u.getFtime());
		ps.setString(7, u.getYtime());
		ps.setString(8, u.getDes());
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public int updateFinance(FinanceInfo f) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("update finance.financeinfo set sishou=?,ftime=?,ytime=?,des=? where cno=? and cid=?");
		ps.setDouble(1, f.getSishou());
		ps.setString(2, f.getFtime());
		ps.setString(3, f.getYtime());
		ps.setString(4, f.getDes());
		ps.setString(5, f.getCno());
		ps.setInt(6, f.getCid());
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

}
