<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="java.util.List" %>
  <%@ page import ="com.model.Book" %>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<%
	List<Book> books = (List<Book>)request.getAttribute("lista");
out.println("<table border=1><tr><th>Author</th><th>Title</th><th>Rating</th><th></th></tr>");
for(Book b:books){
	out.println("<tr><td>");
	out.println("<form method='POST' action='VoteBook'>");
	out.println(String.format("<input type='text' name='author' value='%s'></td>",b.getAuthor()));
	out.println(String.format("<td><input type='text' size='80' name='title' value='%s'></td>",b.getTitle()));
	out.println(String.format("<td><input type='text' name='rating' value='%s'></td>",b.getRating()));
	out.println("<td><input type='submit' value='Vote'></td>");
	out.println("</form></tr>");
	
}

out.println("</table>");
	

%>

<h1>TTTT</h1>

</body>
</html>