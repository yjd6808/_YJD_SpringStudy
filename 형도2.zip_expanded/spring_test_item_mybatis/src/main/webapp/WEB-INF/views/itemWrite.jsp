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
				<td>��ǰ��</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>����</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>����</td>
				<td>
					<input type="text" name="description">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="����"> &nbsp;&nbsp;
					<input type="reset" value="���"> &nbsp;&nbsp;
					<a href="content_view">��ǰ���</a> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>