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
			<td>구매 가격</td>
			<td>한번에 구매 가능한 수량</td>
		</tr>
		<c:forEach items="${items}" var="itemDto">
			<tr>
				<td>${itemDto.u_id}</td>
				<td>${itemDto.itemName}</td>
				<td>${itemDto.itemType}</td>
				<td>${itemDto.buyPrice}</td>
				<td>${itemDto.maxQuantity}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<p>소지 금액 : ${accountDto.money} </p>
	<form method="get" action="../buy.do">
		<input type="number" size="20" name="buy_item_uid" placeholder="구매할 아이템 고유 ID"><br>
		<input type="number" size="20" name="buy_item_count" placeholder="구매할 아이템 갯수"><br>
		<input type="submit" value="구매">
	</form>
	
	<a href="login">로그인 페이지로 이동</a><br>
	<a href="inventory">인벤토리 페이지로 이동</a><br>
</body>
</html>