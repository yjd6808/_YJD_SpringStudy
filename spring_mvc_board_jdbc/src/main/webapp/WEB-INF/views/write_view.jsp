<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<form method="post" action="write">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" size="50"> </td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" size="50"> </td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea rows="10" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�Է�">
					&nbsp;&nbsp; <a href="list">��Ϻ���</a> 
				</td>
			</tr>
		</form>
	</table>
</body>
</html>