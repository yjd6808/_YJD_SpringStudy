<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="writeResult">
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<input type="text" name="description">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="전송"> &nbsp;&nbsp;
					<input type="reset" value="취소"> &nbsp;&nbsp;
					<a href="content_view">상품목록</a> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>