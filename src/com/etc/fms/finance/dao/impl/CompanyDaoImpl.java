package com.etc.fms.finance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.fms.company.entity.Company;
import com.etc.fms.finance.conn.util.ConnectionUtil;
import com.etc.fms.finance.dao.CompanyDao;

public class CompanyDaoImpl implements CompanyDao {

	private ConnectionUtil cu = null;

	public CompanyDaoImpl() {
		this.cu = new ConnectionUtil();
		this.cu.open();
	}

	public int delCompany(int cid) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("delete from finance.company where cid=?");
		ps.setInt(1, cid);
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public Company getCompany(String cname) throws Exception {
		String sql = "select cid,cname,addr,type,flag,xy,cxy from finance.company where cname='"
				+ cname + "'";
		ResultSet rs = cu.executeQuery(sql);
		Company c = null;
		while (rs.next()) {
			c = new Company();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setAddr(rs.getString("addr"));
			c.setType(rs.getString("type"));
			c.setFlag(rs.getInt("flag"));
			c.setXy(rs.getDouble("xy")) ;
			c.setCxy(rs.getDouble("cxy")) ;
		}
		cu.close(rs);
		cu.close();
		return c;
	}

	public List<Company> getCompanys(String cname) throws Exception {
		String sql = "select cid,cname,addr,type,flag,xy,cxy from finance.company where 1=1 ";
		if (cname != null && cname.trim().length() > 0) {
			sql += "and cname like '%" + cname + "%'";
		}
		ResultSet rs = cu.executeQuery(sql);
		List<Company> list = new ArrayList<Company>();
		while (rs.next()) {
			Company c = new Company();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setAddr(rs.getString("addr"));
			c.setType(rs.getString("type"));
			c.setFlag(rs.getInt("flag"));
			c.setXy(rs.getDouble("xy")) ;
			c.setCxy(rs.getDouble("cxy")) ;
			list.add(c);
		}
		return list;
	}

	public int saveCompany(Company c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("insert into finance.company(cname,addr,type,cxy,xy)values(?,?,?,?,?)");
		ps.setString(1, c.getCname());
		ps.setString(2, c.getAddr());
		ps.setString(3, c.getType());
		ps.setDouble(4, c.getXy()) ;
		ps.setDouble(5, c.getXy()) ;
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public int updateCompany(int cid, double xy) throws Exception {
		// TODO Auto-generated method stub
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("update finance.company set xy=? where cid=?");
		ps.setDouble(1,xy) ;
		ps.setInt(2, cid) ;
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public Company getCompany(int cid) throws Exception {
		String sql = "select cid,cname,addr,type,flag,xy,cxy from finance.company where cid="+cid ;
	ResultSet rs = cu.executeQuery(sql);
	Company c = null;
	while (rs.next()) {
		c = new Company();
		c.setCid(rs.getInt("cid"));
		c.setCname(rs.getString("cname"));
		c.setAddr(rs.getString("addr"));
		c.setType(rs.getString("type"));
		c.setFlag(rs.getInt("flag"));
		c.setXy(rs.getDouble("xy")) ;
		c.setCxy(rs.getDouble("cxy")) ;
	}
	cu.close(rs);
	cu.close();
	return c;
	}

}
