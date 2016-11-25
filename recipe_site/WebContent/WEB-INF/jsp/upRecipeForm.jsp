<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<% Recipe recipe = (Recipe) request.getAttribute("recipe");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>レシピ投稿</title>
	</head>
	<body>

		<jsp:include page="/header.jsp"/>

		実際にレシピを投稿していたただいても大丈夫です。<br>


		<form action="UpRecipe" method="post">

			料理名<input type="text" name="title" value="<%=recipe.getTitle()%>">　
			所要時間<input type="text" name="time" value="<%=recipe.getTime()%>">分<br><br>
			<input type="text" name="serving" value="<%=recipe.getServing()%>">人前<br><br>

			　<input type="submit" name="pageName" value="材料追加">　

			<%if(recipe.getFs().size() != 1){ %>
				<input type="submit" name="pageName" value="材料削除"><br><br>
			<%}else{ %>
				<br>
			<%} %>

			　　　　使う材料　　　　　　　　　　　　分量<br>
				<%for(int i = 0; i < recipe.getFs().size(); i++){ %>
				<%=i+1 %><input type="text" name="fs<%=i%>" value="<%=recipe.getFs().get(i) %>">　
				<input type="text" name="quantity<%=i %>" value="<%=recipe.getQuantity().get(i) %>"><br>
			<%} %>

				<br><br>
			　料理の手順　　　　　　<input type="submit" name="pageName" value="手順追加">　

			<%if(recipe.getProcess().size() != 1){ %>
				<input type="submit" name="pageName" value="手順削除"><br>
			<%}else{ %>
				<br>
			<%} %>

			<%for(int i = 0; i < recipe.getProcess().size(); i++){ %>
				<%=i+1 %><input type="text" name="process<%=i %>" value="<%=recipe.getProcess().get(i) %>" size="46"><br>
			<%} %>
			<input type="hidden" name="cook" value="<%=loginUser.getName()%>">
			<input type="hidden" name="u_id" value="<%=loginUser.getU_id()%>">
			<input type="hidden" name="f_size" value="<%=recipe.getFs().size()%>">
			<input type="hidden" name="p_size" value="<%=recipe.getProcess().size()%>"><br>
			<input type="submit" name="pageName" value="登録確認画面">
			</form>

		<jsp:include page="/footer.jsp"/>
	</body>
</html>