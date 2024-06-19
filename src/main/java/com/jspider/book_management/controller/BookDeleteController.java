package com.jspider.book_management.controller;

import java.io.IOException;

import com.jspider.book_management.dao.BookDao;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class BookDeleteController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		new BookDao().deleteBookById(id);
		RequestDispatcher dispatcher=req.getRequestDispatcher("book-display.jsp");
		dispatcher.forward(req, res);
		
	}

}
