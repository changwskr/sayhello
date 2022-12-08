<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here  </title>
</head>
<body>
<h1>Hi ${data }</h1>

<form method="get" action="/plus">
	x : <input type="text" name="x"><br>
	y : <input type="text" name="y"><br>
	<input type="submit" value="plus">
</form>
</body>
</html>