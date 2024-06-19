package com.jspider.book_management.controller;

import java.io.IOException;
import com.jspider.book_management.dao.BookDao;
import com.jspider.book_management.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(value="/bookUpdate")
public class BookUpdateController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookDao dao=new BookDao();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		double price=Double.parseDouble(req.getParameter("price"));
		Book book=new Book(id, title, author, price);
		dao.updateBookDetails(book);
		req.getRequestDispatcher("book-display.jsp").forward(req, resp);
		
	}
}
