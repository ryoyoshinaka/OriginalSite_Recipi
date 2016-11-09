<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>
	<span style="text-align:right;float:right;">
		<%if(loginUser == null){%>
			<a href="loginForm.jsp">ログイン／無料会員登録</a>　
		<%}else {%>
			<a href="Log">ログアウト</a>　
		<%}%>
			<a href="">ランキング</a>　
			<a href="upRecipiForm" method="get">レシピ投稿</a>　
			<a href="">検索</a>　
	</span>
	<a href="topPage.jsp">クッククック</a>
</h3>
-----------------------------------------------------------------------------------------------------------------------------------
<br><br>