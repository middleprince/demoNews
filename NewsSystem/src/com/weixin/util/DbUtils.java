package com.weixin.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/apicloudLearn", "root", "123456");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		DbUtils.getConnection();
	}
}
