package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookDAO {

	public static void performCreateBook(String title, String author, String rating, int userId) {

		String insertBook = "INSERT INTO FQP56733.BOOK (BOOKID,TITLE,AUTHOR,RATING) VALUES(" + "NEXT VALUE FOR BOOK_ID_SEQ, "
				+ "'" + title + "', " + "'" + author + "', " + "'" + rating + "')";
		
		try (Connection conn = AppConnection.getDSConnection()) {
			conn.setAutoCommit(false);
			int i = 0;
			try(PreparedStatement stmt = conn.prepareStatement(insertBook)){
				i = stmt.executeUpdate();
				if (i > 0) {
					System.out.println("Statement executed successfully");
					String sql = "select max(bookid) from FQP56733.BOOK";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						 int id = rs.getInt(1);
						 performCreateScore(conn,userId,id);
					}
					   
					
					conn.commit();
				} else {
					System.out.println("No update statement was executed");
				}
				
			}catch(SQLException ex){
				ex.printStackTrace();
				conn.rollback();
			}finally{
				conn.setAutoCommit(true);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private static void performCreateScore(Connection conn,int userId, int bookSeq) throws SQLException{
		LocalDate date = LocalDate.now();
		int i=0;
		String insertScore =  "INSERT INTO FQP56733.SCORE (BOOKID,USERID,DATE) VALUES(" + "'" + bookSeq + "', " + "'" + userId + "', " + "'" + date + "')";
		
				try(PreparedStatement stmt = conn.prepareStatement(insertScore)){
					i = stmt.executeUpdate();
					if (i > 0) {
						System.out.println("Statement executed successfully");
					
					} else {
						System.out.println("No update statement was executed");
					}
					
	}
	}

}
