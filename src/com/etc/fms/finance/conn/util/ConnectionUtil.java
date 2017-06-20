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
	 * �����ݿ�
	 */
	public void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fms", "root", "root");
			System.out.println("�����ݿ�����");
		} catch (Exception ex) {
			System.err.println("�����ݿ�ʱ����: " + ex.getMessage());
		}
	}

	/**
	 * �ر����ݿ⣬�����ӷ��������ӳ�
	 */
	public void close() {
		try {

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("�ͷ�����");
		} catch (SQLException ex) {
			System.err.println("�������ӳس���: " + ex.getMessage());
		}
	}

	public void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}

		} catch (SQLException ex) {
			System.err.println("�ر�PS�쳣: " + ex.getMessage());
		}
	}

	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException ex) {
			System.err.println("�ر�RS�쳣: " + ex.getMessage());
		}
	}

	/**
	 * ִ�в�ѯ
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		ResultSet rs = null;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;
	}

	/**
	 * ִ����ɾ��
	 */
	public int executeUpdate(String sql) throws SQLException {
		int ret = 0;
		stmt = conn.createStatement();
		ret = stmt.executeUpdate(sql);

		System.out.println("ִ����ɾ��");
		return ret;
	}

	/**
	 * ��SQL�����뵽������
	 */
	public void addBatch(String sql) throws SQLException {
		stmt = conn.createStatement();
		stmt.addBatch(sql);
	}

	/**
	 * ִ��������
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
