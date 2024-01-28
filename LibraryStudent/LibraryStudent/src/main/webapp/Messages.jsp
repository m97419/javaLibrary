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
			<td width = "119"  ><b>message</b></td>
		</tr>
		
		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("messageData"); 
		   for(itr=data.iterator();itr.hasNext();)   
		   {
		%>
		<tr>
			<td width = "119"><%=itr.next() %></td>
		</tr>
		<% } %>
	</table>
	<!--<form method="post" action="ReturnServlet">
		<input type="hidden" name="path" value="/WorkerHomePage.jsp">
		<input type="submit" value="Back">
	</form>-->
</body>
</html>