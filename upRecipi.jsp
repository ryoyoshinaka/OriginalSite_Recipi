<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.View,java.util.ArrayList"%>
<%ArrayList<String> fs = (ArrayList<String>)session.getAttribute("fs");%>
<%View view = (View) session.getAttribute("view"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=view.getPageName()%></title>
	</head>
	<body>
		<%for(String s: fs){%>
			<%if(){%>
				<%=s%><br>
		<%}%>
		<br><%=view.getMsg()%>
	</body>
</html>