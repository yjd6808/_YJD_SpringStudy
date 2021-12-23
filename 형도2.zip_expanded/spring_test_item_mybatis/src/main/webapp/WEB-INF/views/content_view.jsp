<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<tr>
			<td>이름</td>
			<td>가격</td>
			<td>설명</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.name}</td>
				<td>${dto.price}</td>
				<td>${dto.description}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<a href="write">글쓰기</a>
			</td>
		</tr> 
	</table>
</body>
</html>