<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="write" method="get">
		<table width="500" border="1">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea rows="10" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="����"></td>
			</tr>
		</table>
	</form>
</body>
</html>
