<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>Search by book title or author</div>
	<form method="POST" action="SearchBook">
		<label for="searchbox">Insert book title or author</label>
		<input type="text" name="search"/><br><br>
		<input type="submit" value="Search">
		<input type="reset" value="Reset">
	</form>
</body>
</html>