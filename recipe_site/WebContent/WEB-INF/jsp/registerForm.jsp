<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<% User user = (User) request.getAttribute("user"); %>
<% View view = (View) request.getAttribute("view"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新規登録</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
		<h1>新規登録</h1>
		<%=view.getMsg() %>
		<form action="Register" method="post">
			ニックネーム<input type="text" name="name" value="<%=user.getName() %>"><br>
			ID<input type="text" name="u_id" value="<%=user.getU_id() %>"><br>
			メールアドレス<input type="text" name="mail" value="<%=user.getMail() %>"><br>
			パスワード<input type="password" name="pass"><br>
			パスワード(確認用)<input type="password" name="pass2"><br><br>
			<input type="submit" name="pageName" value="登録確認">
		</form>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>