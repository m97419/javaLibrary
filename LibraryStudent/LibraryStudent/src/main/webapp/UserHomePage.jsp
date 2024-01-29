<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import="java.util.*" import = "registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
<form method="post" action="../../AddMessage.jsp">
		<%User user = (User)(request.getAttribute("userDetails")); %>
		<input type="hidden" name="userId" value="<%=user.getId()%>">
		<input type="submit" value="To Add Message">
	</form>
	<form method="post" action="/LibraryStudent/GetHistoryServlet">
		<input type="hidden" name="userId" value="<%=user.getId()%>">
		<input type="submit" value="history...">
	</form>
	<form method="post" action="/LibraryStudent/GetBooksServlet">
	<input type="hidden" name="status" value="1">
		<input type="hidden" name="find" value="">
		<input type="submit" value="your laon books">
	</form>
</body>
</html>