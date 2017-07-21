package com.javaex.jdbc.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="select book_id, "
					+"title, pubs,pub_date,author_id from book";
			pstmt=conn.prepareStatement(query);
			int count=pstmt.executeUpdate();
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int bookId=rs.getInt("book_id");
				String bookTitle=rs.getString("title");
				String bookPubs=rs.getString("pubs");
				String bookDate=rs.getString("pub_date");
				int author_id=rs.getInt("author_id");
				
				System.out.println(bookId+"\t"+bookTitle+"\t"+bookPubs+"\t"+bookDate+"\t"+author_id);
			}
			
			System.out.println(count+"건 처리");
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error"+e);
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

}}
