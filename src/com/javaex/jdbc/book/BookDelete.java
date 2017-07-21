package com.javaex.jdbc.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDelete {

	public static void main(String[] args) {
		
		//0.import java.sql.*;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			
			//1.JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="delete from book"
					+" where book_id=11";
			pstmt=conn.prepareStatement(query);
			pstmt.executeQuery();
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}finally {
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
	}

}
