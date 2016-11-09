<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新規登録</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
		<h1>新規登録</h1>
		<form action="Register" method="post">
			ニックネーム<input type="text" name="name"><br>
			ID<input type="text" name="id"><br>
			メールアドレス<input type="text" name="mail"><br>
			パスワード<input type="password" name="pass"><br>
			パスワード(確認用)<input type="password" name="pass2"><br>
			<input type="hidden" name="pageName" value="登録確認">
			<input type="submit" value="登録確認画面">
		</form>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>