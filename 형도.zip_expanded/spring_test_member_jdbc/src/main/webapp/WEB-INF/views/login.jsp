<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login_yn">
		<table width="400" border="1">
			<tr>
				<td align="center">����� ID</td>
				<td>
					<input type="text" name="memUid">
				</td>
			</tr>
			<tr>
				<td align="center">��й�ȣ</td>
				<td>
					<input type="password" name="memPwd">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="�α���"> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="register">ȸ������</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>