<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>��ǰ��</td>
			<td>����</td>
			<td>����</td>
		</tr>
		<c:forEach items="${list }" var="item">
			<tr>
				<td>${ item.name }</td>
				<td>${ item.price }</td>
				<td>${ item.description }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>