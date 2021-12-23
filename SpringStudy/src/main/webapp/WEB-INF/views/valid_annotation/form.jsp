<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="check">
		<input type="text" name="name" value="${ student.name }"><br>
		<input type="text" name="pass" value="${ student.pass }"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>