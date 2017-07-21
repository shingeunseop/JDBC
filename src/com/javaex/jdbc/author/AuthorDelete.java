package com.javaex.jdbc.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDelete {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="DELETE from author " + 
					"where author_id=6";
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
