<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<form method="post" action="registerOk">
			<tr>
				<td colspan="2">
					<h1>ȸ�� ���� ��û</h1>
				</td> 
			</tr>
			<tr height="30">
				<td width="80">
				 	User ID
				</td>
				<td>
				 	<input type="text" name="memUid" size="20">
				</td>  
			</tr>
			<tr height="30">
				<td width="80">
				 	��ȣ
				</td>
				<td>
				 	<input type="password" name="memPwd" size="20">
				</td>  
			</tr>
			<tr height="30">
				<td width="80">
				 	�̸�
				</td>
				<td>
				 	<input type="text" name="memName" size="20">
				</td>  
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="���">
				</td> 
			</tr>
		</form>
	</table>
</body>
</html>