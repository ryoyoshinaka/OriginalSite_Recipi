<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//function で関数を定義
var count = 0;
function test(){
	console.log("test呼ばれたよ");
	//追加したいform の id を指定して持ってくる
	var test10 = document.getElementById("test10");
	// 追加するinputを生成
	var form1 = document.createElement("form");
	form1.id = "form" + count++;
	
	var inputTxt = document.createElement("input");
	// 入力したい形式を文字列で指定
	inputTxt.type = "text";
	form1.appendChild(inputTxt);
	
	// form に追加する
	test10.appendChild(form1);
}

</script>
</head>
<body>
<form id="test10" action="">
	<input type="text"/>
</form>
 <!-- (コメントアウト)onclick で呼ばれる関数名を指定 -->
<button onclick="test()">ボタンだよ</button>
</body>
</html>