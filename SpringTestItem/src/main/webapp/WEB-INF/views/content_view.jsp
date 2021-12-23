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
			<td>상품명</td>
			<td>가격</td>
			<td>설명</td>
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