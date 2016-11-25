<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<%View view = (View) request.getAttribute("view"); %>
<%Recipe recipe = (Recipe) request.getAttribute("recipe"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=view.getPageName()%></title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>

		料理名　<%=recipe.getTitle()%>　　所要時間　<%=recipe.getTime()%><br>
		<%=recipe.getServing()%>人前<br><br>
		　　　　　　　　<br>

		<div style="float:left;">

			使う材料<br>
			<%for(int i = 0; i < recipe.getFs().size(); i++){ %>
				<%=i + 1 %>　<%=recipe.getFs().get(i) %><br>
			<%} %>
		</div>

		　　　　　分量<br>
		<%for(int i = 0; i < recipe.getQuantity().size(); i++){ %>
				　　　　　<%=recipe.getQuantity().get(i) %><br>
		<%} %><br>

		料理の手順<br>
		<%for(int i = 0; i < recipe.getProcess().size(); i++){ %>
			<%=i + 1 %>　<%=recipe.getProcess().get(i) %><br>
		<%} %><br>

		<%if(view.getPageName().equals("登録確認画面")){%>
			<form action="UpRecipe" method="post">
				<input type="hidden" name="title" value="<%=recipe.getTitle()%>">
				<input type="hidden" name="time" value="<%=recipe.getTime()%>">
				<input type="hidden" name="serving" value="<%=recipe.getServing()%>">
				<input type="hidden" name="cook" value="<%=recipe.getCook()%>">
				<input type="hidden" name="u_id" value="<%=recipe.getU_id()%>">
				<input type="hidden" name="f_size" value="<%=recipe.getFs().size()%>">
				<input type="hidden" name="p_size" value="<%=recipe.getProcess().size() %>">

				<%for(int i = 0; i < recipe.getFs().size(); i++){ %>
					<input type="hidden" name="fs<%=i %>" value="<%=recipe.getFs().get(i) %>">
					<input type="hidden" name="quantity<%=i %>" value="<%=recipe.getQuantity().get(i)%>">
				<%} %>

				<%for(int i= 0; i < recipe.getProcess().size(); i++) {%>
					<input type="hidden" name="process<%=i %>" value="<%=recipe.getProcess().get(i) %>">
				<%} %>

				<%=view.getMsg()%>
				<input type="submit" name="pageName" value="登録結果">
			</form>
		<%}else if(view.getPageName().equals("登録結果")){%>
			上記の内容で登録しました。
		<%}%>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>