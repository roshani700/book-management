package com.jspider.book_management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jspider.book_management.dao.BookDao;
import com.jspider.book_management.dto.Book;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class BookInsertController implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BookDao dao=new BookDao();
		PrintWriter printWriter=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		String author=req.getParameter("author");
		double price=Double.parseDouble(req.getParameter("price"));
//		System.out.println(id+" "+title+" "+author+" "+price);
		Book book=new Book(id, title, author, price);
		dao.addBook(book);
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}
