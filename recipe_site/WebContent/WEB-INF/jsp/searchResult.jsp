<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<% ArrayList<Recipe> searchRecipes  = (ArrayList<Recipe>) session.getAttribute("searchRecipes");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>検索結果</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>

		<%=searchRecipes.size()%>件のレシピがヒットしました。<br><br>

		<%for(int i = 0; i < searchRecipes.size(); i++){ %>
			<a href="SearchRecipe?r_id=<%=searchRecipes.get(i).getR_id()%>"><%=searchRecipes.get(i).getTitle() %></a>　　<%=searchRecipes.get(i).getCook() %>さん<br><br>
		<%} %>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>