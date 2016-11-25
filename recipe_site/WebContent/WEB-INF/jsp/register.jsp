<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<%
	User user = (User) request.getAttribute("user");
	View view = (View) request.getAttribute("view");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%= view.getPageName() %></title>
	</head>
	<body>

		<jsp:include page="/header.jsp"/>
		ニックネーム：<%= user.getName() %><br>
		ID：<%= user.getU_id() %><br>
		メールアドレス：<%= user.getMail()%><br>

		パスワード：
		<%for(int i = 0; i < user.getPass().length(); i++){ %>
			●
		<%} %>
		<br>

		<%if(view.getPageName().equals("登録確認")){%>

			上記の内容で登録しますか？<br>
			<form action="Register" method="post">
				<input type="hidden" name="name" value="<%=user.getName()%>">
				<input type="hidden" name="u_id" value="<%=user.getU_id()%>">
				<input type="hidden" name="mail" value="<%=user.getMail()%>">
				<input type="hidden" name="pass" value="<%=user.getPass() %>">
				<input type="submit" name="pageName" value="登録">
			</form>

		<%}else{%>
			上記の内容で登録しました。
		<%}%>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>