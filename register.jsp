<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.View"%>
<%
	User user = (User) session.getAttribute("user");
	View view = (View) session.getAttribute("view");
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
		ID：<%= user.getId() %><br>
		メールアドレス：<%= user.getMail()%><br>
		パスワード：<%= user.getPass() %><br>

		<%if(view.getPageName().equals("登録確認")){%>
			上記の内容で登録しますか？<br>
			<form action="Register" method="post">
				<input type="hidden" name="pageName" value="登録結果">
				<input type="submit" value="登録">
			</form>
		<%}else if(view.getPageName().equals("登録結果")){%>
			上記の内容で登録しました。
		<%}%>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>