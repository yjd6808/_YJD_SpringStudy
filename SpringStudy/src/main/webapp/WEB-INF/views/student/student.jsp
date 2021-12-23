<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="student" method="get">
		<input type="text" name="id"><br>
		<input type="submit" value="GET">
	</form>
	
	<form action="student" method="post">
		<input type="text" name="id"><br>
		<input type="submit" value="POST">
	</form>
</body>
</html>