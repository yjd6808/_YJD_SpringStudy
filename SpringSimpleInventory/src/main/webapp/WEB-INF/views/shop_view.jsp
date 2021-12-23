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
			<td>���� ���̵�</td>
			<td>������ �̸�</td>
			<td>������ Ÿ��</td>
			<td>���� ����</td>
			<td>�ѹ��� ���� ������ ����</td>
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
	<p>���� �ݾ� : ${accountDto.money} </p>
	<form method="get" action="../buy.do">
		<input type="number" size="20" name="buy_item_uid" placeholder="������ ������ ���� ID"><br>
		<input type="number" size="20" name="buy_item_count" placeholder="������ ������ ����"><br>
		<input type="submit" value="����">
	</form>
	
	<a href="login">�α��� �������� �̵�</a><br>
	<a href="inventory">�κ��丮 �������� �̵�</a><br>
</body>
</html>