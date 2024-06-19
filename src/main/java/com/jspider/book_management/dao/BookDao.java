package com.jspider.book_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.book_management.connection.BookConnection;
import com.jspider.book_management.dto.Book;

public class BookDao {
	
	Connection connection=BookConnection.getBookConnection();
	PreparedStatement ps;
	
	private final String INSERT_BOOK_QUERY="insert into book(id,title,author,price) values (?,?,?,?)";
	
	private final String DISPLAY_BOOK_QUERY="select * from book";
	
	private final String DISPLAY_BOOK_BY_ID_QUERY="select * from book where id=?";
	
	private final String UPDATE_BOOK_DETAILS_QUERY="update book set title=?, author=?, price=? where id=?";
	
	private final String DELETE_BOOK_QUERY="delete  from book where id=?";
	public void addBook(Book book){
		try {
			ps=connection.prepareStatement(INSERT_BOOK_QUERY);
			ps.setInt(1,book.getId() );
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.execute();
			System.out.println("Book Added....");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Book not Added...");
		}
	}
	
	public List<Book> showbookList(){
		List<Book> books=new ArrayList<Book>();
		try {
			ps=connection.prepareStatement(DISPLAY_BOOK_QUERY);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("title");
				String author=rs.getString("author");
				double price=rs.getDouble("price");
				Book book=new Book(id, title, author, price);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	

		public Book getBookById(int id) {
	
		try {
			ps=connection.prepareStatement(DISPLAY_BOOK_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			Book book=null;
			while(rs.next()) {
				int id1=rs.getInt("id");
				String title=rs.getString("title");
				String author=rs.getString("author");
				double price=rs.getDouble("price");
				if(id==id1)
					book=new Book(id1, title, author, price);
				}
			return book;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateBookDetails(Book book) {
		try {
			ps=connection.prepareStatement(UPDATE_BOOK_DETAILS_QUERY);
			ps.setString(1,book.getTitle());
			ps.setString(2,book.getAuthor());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getId());
			System.out.println(book.getAuthor());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteBookById(int id) {
		try {
			ps=connection.prepareStatement(DELETE_BOOK_QUERY);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		return 0;
		}
		
	}

}
