<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<%
	View view = (View) request.getAttribute("view");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%= view.getPageName()%></title>
	</head>
		<body>
		<jsp:include page="/header.jsp"/>
		<%= view.getMsg() %>
		<jsp:include page="/footer.jsp"/>
		</body>
</html>