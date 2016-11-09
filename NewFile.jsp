<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function add()
{
    var div_element = document.createElement("div");
    div_element.innerHTML = '<input type="text" name="title" value="a">';
    var parent_object = document.getElementById("piyo");
    parent_object.appendChild(div_element);
}
</script>
</head>

<body>

<div>
<button onclick="add();">追加！</button>
</div>

<div id="piyo">
</div>

</body>
</html>
