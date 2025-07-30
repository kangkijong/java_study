package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	//Field
	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	//Constructor
	protected DBConn() {
		try {
			//1단계
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("----> 1단계 성공!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement 생성	--> Statement보다 보안성이 더 좋음!! 사용한다면 PreparedStatement로 사용하기!!
	public void getPreparedStatement(String sql) {
		try {
			//2단계 : PreparedStatement 객체 생성
			pstmt = connection.prepareStatement(sql);
			System.out.println("----> 2단계 성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement 생성
	public void getStatement() {
		try {
			//2단계 : Statement 객체 생성
			stmt = connection.createStatement();
			System.out.println("----> 2단계 성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//객체 종료
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
