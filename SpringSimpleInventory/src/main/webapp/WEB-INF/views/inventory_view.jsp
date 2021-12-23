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
	<table border="1">
		<tr>
			<td>고유 아이디</td>
			<td>아이템 이름</td>
			<td>아이템 타입</td>
			<td>소지 갯수</td>
		</tr>
		<c:forEach items="${items}" var="invenItemDto">
			<tr>
				<td>${invenItemDto.u_id}</td>
				<td>${invenItemDto.itemInfo.itemName}</td>
				<td>${invenItemDto.itemInfo.itemType}</td>
				<td>${invenItemDto.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<form method="get" action="../sell.do">
		<input type="number" size="20" name="sell_item_uid" placeholder="판매할 아이템 고유 ID"><br>
		<input type="number" size="20" name="sell_item_count" placeholder="판매할 아이템 갯수"><br>
		<input type="submit" value="판매">
	</form>
	
	<a href="login">로그인 페이지로 이동</a><br>
	<a href="shop">상점 페이지로 이동</a><br>
</body>
</html>