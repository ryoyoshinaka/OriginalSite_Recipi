<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<%View view = (View) request.getAttribute("view");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログインページ</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
		<%=view.getMsg() %>
		<form action="Login" method="post">
			登録ID<input type="text" name="u_id">
			パスワード<input type="password" name="pass">
			<input type="submit" value="ログイン">
		</form>
		<a href="Register">新規登録の方はこちら</a>

		<br><br>idは　a　パスワードは　a　で入れます。<br>
		新規登録していただいても大丈夫です。

		<jsp:include page="/footer.jsp"/>
	</body>
</html>