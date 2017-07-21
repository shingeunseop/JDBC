package com.javaex.jdbc.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {
		int count=-1;
		String name="강풀";
		String desc="웹툰1세대";
		
		//0. import java.sql.*;
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
		String query="insert into author values(seq_book_id.nextval, ?, ?)";//?는 변수
		pstmt=conn.prepareStatement(query);//쿼리를 날리는 문장
		
		pstmt.setString(1,name);
		pstmt.setString(2, desc);
		count=pstmt.executeUpdate();
		
		// 4.결과처리
		System.out.println(count+"건 처리");
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

