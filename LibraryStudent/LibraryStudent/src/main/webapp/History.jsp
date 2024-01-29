<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>library</title>
</head>
<body>
<table style="width:70%;background-color: skyblue;margin-top:200px;margin-left:100px;margin-right:200px;">
	
		<tr>
			<td width = "119"  ><b>Name</b></td>
			<td width = "168"  ><b>Author</b></td>
			<td width = "168"  ><b>Description</b></td>
		</tr>
		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("historyData"); 
		   for(itr=data.iterator();itr.hasNext();)   
		   {
		%>
		<tr>
			<td width = "119"><%= itr.next()%></td>
			<td width = "168"><%= itr.next()%></td>
			<td width = "168"><%= itr.next()%></td>
			<%= itr.next()%>
		</tr>
		<% } %>
	</table>
</body>
</html>