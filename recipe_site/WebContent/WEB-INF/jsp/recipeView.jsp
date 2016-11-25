<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/common.jsp"%>

<%Recipe recipe = (Recipe) request.getAttribute("recipe");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=recipe.getTitle() %></title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>

		<%=recipe.getTitle() %>料理人　<%=recipe.getCook() %>さん　　
		<form action="Good" method="get">
			<input type="hidden" name="u_id" value="<%=loginUser%>">
			<input type="submit" value="いいね">
		</form>
		<br><br>
		<%=recipe.getServing() %>人前　所要時間　<%=recipe.getTime()%>分<br><br>

		<div style="float:left;">

			　　使う材料　　　<br>
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



		<jsp:include page="/footer.jsp"/>
	</body>
</html>