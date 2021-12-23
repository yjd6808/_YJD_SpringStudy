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
		<input type="number" size="20" name="sell_item_uid" placeholder="�Ǹ��� ������ ���� ID"><br>
		<input type="number" size="20" name="sell_item_count" placeholder="�Ǹ��� ������ ����"><br>
		<input type="submit" value="�Ǹ�">
	</form>
	
	<a href="login">�α��� �������� �̵�</a><br>
	<a href="shop">���� �������� �̵�</a><br>
</body>
</html>