package com.javaex.jdbc.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert {

	public static void main(String[] args) {
		String name="김규삼";
		String desc="웹툰0세대";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="insert into book values(seq_book_id.nextval,?,?,'07/01/01',7)";
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2, desc);
			int count=pstmt.executeUpdate();
			
			
			System.out.println(count+"건 처리");
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
