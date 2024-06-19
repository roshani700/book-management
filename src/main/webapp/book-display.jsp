<%@page import="com.jspider.book_management.dao.BookDao"%>
<%@page import="java.util.List"%>
<%@page import="com.jspider.book_management.dto.Book"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="book-display.css">
</head>
<body>
	<% BookDao bookDao=new BookDao();
		List<Book> books=bookDao.showbookList();
	%>

	<header>
	<h1>Books Management</h1>
	</header>
	<div class="Anchor">
	<a href="./book-register.jsp">Add New Book</a>
	<a href="book-display.jsp">List All Books</a>
	</div>
	<section>
	<table border="2" cellpadding="10px">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
			<th colspan="2">Actions</th>
		</tr>
		<%for(Book book : books){ %>
		<tr>
			<td><%=book.getId() %></td>
			<td><%=book.getTitle() %></td>
			<td><%=book.getAuthor() %></td>
			<td><%=book.getPrice() %></td>
			<td><a href="book-update.jsp?id=<%=book.getId()%>"><button style="color : green;">Edit</button></a></td>
			<td><a href="delete?id=<%=book.getId()%>"><button style="color : red; ">DELETE</button></a></td>
		</tr>
	<%} %>
	</table>
	</section>

</body>
</html>