package com.bsd.bts530;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectMySQL {

	private Connection cn;

	public void connectDB() {
		try {
			// loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

			// create connection with the database
			this.cn = DriverManager.getConnection("jdbc:mysql:/ /Localhost:8080/test", "user", "bst530");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkUser(String email, String pwd) {

		boolean str = false;

		try {

			PreparedStatement ps = this.cn.prepareStatement("select * from register where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			str = rs.next();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return str;
	}

	public boolean insertLocation(String lat, String lon) {
		boolean re = false;
		
		try {
			
			PreparedStatement ps = this.cn.prepareStatement("insert into location (lat,lon) value (?,?)");
			ps.setString(0, lat);
			ps.setString(1, lon);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return re;
	}
}
