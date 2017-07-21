package com.javaex.jdbc.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class AuthorUpdate {

	public static void main(String[] args) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			
		//1. JDBC 드라이버 (Oracle) 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//프로그램 로딩 가져옴
		
		
		//2. Connection 얻어오기
		String url="jdbc:oracle:thin:@localhost:1521:xe";//db주소
		conn=DriverManager.getConnection(url,"webdb","webdb");//정보 다 가짐
		System.out.println("접속성공");
		
		
		
		//3. SQL문 준비 / 바인딩 / 실행
		String query="update author "
				+"set author_name='기안고등', "
				+"author_desc='웹툰작가' "
				+"where author_id=5";
		pstmt=conn.prepareStatement(query);
		pstmt.executeQuery();//commit
		
		
		
		// 4.결과처리
		
	}catch(ClassNotFoundException e) {
		System.out.println("error:드라이벌딩 실패."+e);
	}catch(SQLException e) {
		System.out.println("error:"+e);
	}finally {
		
		
		//5. 자원정리
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			
		
			
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}
		

	}

	}}