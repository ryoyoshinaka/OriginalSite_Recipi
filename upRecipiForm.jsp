<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%ArrayList<String> fs = (ArrayList<String>)session.getAttribute("fs");%>
<%int count = 0;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>レシピ投稿</title>
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
		　　　　　　　材料　　　　　　　　　　　　分量
		<form action="upRecipiForm" method="post">
			<%for(String s: fs) {%>
				<%if(count % 2 == 0){%>
					<%=(count/2)+1%><input type="text" name="fs<%=count%>" value="<%=s%>">
				<%}else{%>
					<input type="text" name="fs<%=count%>" value="<%=s%>"><br>
				<%}%>
					<%count++;%>
			<%}%>
			<input type="hidden" name="count" value="<%=count%>">
			<br>
			<input type="submit" name="judge" value="登録確認画面">
			<input type="submit" name="judge" value="材料を追加">
		</form>
		<jsp:include page="/footer.jsp"/>
	</body>
</html>