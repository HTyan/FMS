package com.etc.fms.finance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.fms.finance.conn.util.ConnectionUtil;
import com.etc.fms.finance.dao.UserDao;
import com.etc.fms.user.entity.User;

public class UserDaoImpl implements UserDao {

	private ConnectionUtil cu = null;

	public UserDaoImpl() {
		this.cu = new ConnectionUtil();
		this.cu.open();
	}

	public User getUser(String loginname, String password) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select uid,loginname,username,age,tel,gender,role from finance.user where loginname='"
				+ loginname + "' and password='" + password + "'";
		ResultSet rs = cu.executeQuery(sql);
		User u = null;
		while (rs.next()) {
			u = new User();
			u.setUid(rs.getInt("uid"));
			u.setLoginname(rs.getString("loginname"));
			u.setUsername(rs.getString("username"));
			u.setAge(rs.getInt("age"));
			u.setGender(rs.getString("gender"));
			u.setTel(rs.getString("tel"));
			u.setRole(rs.getString("role"));
		}
		cu.close(rs);
		cu.close();
		return u;
	}

	public List<User> getUsers(String lognname, String username)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "select uid,loginname,username,age,gender,tel,role from finance.user where 1=1 ";
		if (lognname != null && lognname.trim().length() > 0) {
			sql += "and loginname like '%" + lognname + "%'";
		}
		if (username != null && username.trim().length() > 0) {
			sql += "and username like '%" + username + "%'";
		}
		sql += " order by uid desc";
		ResultSet rs = cu.executeQuery(sql);
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setUid(rs.getInt("uid"));
			u.setLoginname(rs.getString("loginname"));
			u.setUsername(rs.getString("username"));
			u.setAge(rs.getInt("age"));
			u.setGender(rs.getString("gender"));
			u.setTel(rs.getString("tel"));
			u.setRole(rs.getString("role"));
			list.add(u);
		}
		return list;
	}

	public int saveUser(User u) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("insert into finance.user(loginname, password,username,age,gender,tel,role)values(?,?,?,?,?,?,?)");
		ps.setString(1, u.getLoginname());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getUsername());
		ps.setInt(4, u.getAge());
		ps.setString(5, u.getGender());
		ps.setString(6, u.getTel());
		ps.setString(7, u.getRole());
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

	public int delUser(int uid) throws Exception {
		Connection con = cu.getConn();
		PreparedStatement ps = con
				.prepareStatement("delete from  finance.user where uid=?");
		ps.setInt(1, uid);
		int suc = ps.executeUpdate();
		cu.close(ps);
		cu.close();
		return suc;
	}

}
