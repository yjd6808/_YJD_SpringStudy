<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	createPage.jsp�Դϴ�.
	<form action="student/create"> <!-- url �����Ѵ�. -->
		���̵�: <input type="text" name="id" value="${student.id}"> <br>
		��й�ȣ: <input type="password" name="pw" value="${student.pw}"> <br>
		         <input type="submit" value="����">
	</form>
</body>
</html>