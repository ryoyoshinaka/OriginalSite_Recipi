<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>トップページ</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
		レシピ検索<br>
		<form action="search" method="get">
		<input type="text" name="food">
		<input type="submit" value="検索">
		</form><br>
		～流行りの料理～

		<jsp:include page="/footer.jsp"/>
	</body>
</html>