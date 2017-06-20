package com.etc.fms.finance.conn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public Connection getConn() {
		return conn;
	}

	private Connection conn;
	private Statement stmt;

	public ConnectionUtil() {
	}

	/**
	 * 打开数据库
	 */
	public void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fms", "root", "root");
			System.out.println("打开数据库连接");
		} catch (Exception ex) {
			System.err.println("打开数据库时出错: " + ex.getMessage());
		}
	}

	/**
	 * 关闭数据库，将连接返还给连接池
	 */
	public void close() {
		try {

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("释放连接");
		} catch (SQLException ex) {
			System.err.println("返还连接池出错: " + ex.getMessage());
		}
	}

	public void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}

		} catch (SQLException ex) {
			System.err.println("关闭PS异常: " + ex.getMessage());
		}
	}

	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException ex) {
			System.err.println("关闭RS异常: " + ex.getMessage());
		}
	}

	/**
	 * 执行查询
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		ResultSet rs = null;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;
	}

	/**
	 * 执行增删改
	 */
	public int executeUpdate(String sql) throws SQLException {
		int ret = 0;
		stmt = conn.createStatement();
		ret = stmt.executeUpdate(sql);

		System.out.println("执行增删改");
		return ret;
	}

	/**
	 * 将SQL语句加入到批处理
	 */
	public void addBatch(String sql) throws SQLException {
		stmt = conn.createStatement();
		stmt.addBatch(sql);
	}

	/**
	 * 执行批处理
	 */
	public int[] executeBatch() throws SQLException {
		boolean isAuto = conn.getAutoCommit();

		conn.setAutoCommit(false);
		int[] updateCounts = stmt.executeBatch();

		// conn.commit();

		// conn.setAutoCommit(isAuto);
		// conn.setAutoCommit(true);
		return updateCounts;
	}

	public boolean getAutoCommit() throws SQLException {
		return conn.getAutoCommit();
	}

	public void setAutoCommit(boolean auto) throws SQLException {
		conn.setAutoCommit(auto);
	}

	public void commit() throws SQLException {
		conn.commit();
		// this.close();
	}

	public void rollBack() throws SQLException {
		conn.rollback();
		// this.close();
	}

	
	
}
