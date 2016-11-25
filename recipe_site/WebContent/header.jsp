<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
      </ul>
    </div>
  </div>
</nav>

<div style="background:#FFFF44;margin:0;">
	<h3>
		<div style="float:right;"><br><br><br>
			<%if(loginUser == null){%>
				<a href="Login">ログイン／無料会員登録</a>　
			<%}else {%>
				<a href="Logout">ログアウト</a>　
			<%}%>
				<a href="">ランキング</a>　
				<a href="UpRecipe">レシピ投稿</a>　
				<a href="searchRecipeForm.jsp">検索</a>　
		</div>
	</h3>
	<h2>
		<a href="index.jsp"><img src="./title.png" border="0"></a><br>
	</h2>
</div>
<br>