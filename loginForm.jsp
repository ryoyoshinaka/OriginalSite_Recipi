<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログインページ</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
		<form action="Log" method="post">
			登録ID<input type="text" name="id">
			パスワード<input type="password" name="pass">
			<input type="submit" value="ログイン">
		</form>
		<a href="registerForm.jsp">新規登録の方はこちら</a>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>