<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	createPage.jsp입니다.
	<form action="student/create"> <!-- url 지정한다. -->
		아이디: <input type="text" name="id" value="${student.id}"> <br>
		비밀번호: <input type="password" name="pw" value="${student.pw}"> <br>
		         <input type="submit" value="전송">
	</form>
</body>
</html>