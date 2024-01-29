<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import = "java.util.*" import = "registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
<table style="width:70%;background-color: skyblue;margin-top:200px;margin-left:50px;margin-right:200px;">
		<tr>
			<td width = "119"  ><b>User Name</b></td>
			<td width = "168"  ><b>Address</b></td>
			<td width = "168"  ><b>Phone Number</b></td>
		</tr>
		
		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("usersData"); 
		   for(itr=data.iterator();itr.hasNext();)   
		   {
			   User user = (User)(itr.next());
		%>
		<tr>
			<td width = "119"><%= user.getUserName()%></td>
			<td width = "168"><%= user.getAddress()%></td>
			<td width = "168"><%= user.getPhoneNum()%></td>
			<% if(user.isHaveLaons()) {%>
				<td>have loan books...</td>
			<% } 
			else{%>
			<td><form method="post" action="DeleteUserServlet">
				<input type="hidden" name="id" value="<%= user.getId()%>">
				<input type="submit" name="delete" value="delete">
			</form></td>
		</tr>
		<% } %>
		<% } %>
	</table>
	<form action="Registration.jsp">
		<input type="submit" name="addUser" value="addUser">
	</form>
</body>
</html>