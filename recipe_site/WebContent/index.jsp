<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="bootstrap.css">
			<title>トップページ</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>

		ラーメンで検索すると出てきます。<br><br>

		レシピ検索（料理名だけ）<br>
		<form action="SearchRecipes" method="get">
		<input type="text" name="word">
		<input type="submit" value="検索">
		</form><br>
		～流行りの料理～<br>

工事中

		<jsp:include page="/footer.jsp"/>
	</body>
</html>