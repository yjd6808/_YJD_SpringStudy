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
		<form method="post" action="modify">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<td>��ȣ</td>             
				<td>${content_view.bId}</td> <!--content_view�� �ѱ䰪�� �޴´�.  -->
			</tr>
			<tr>
				<td>��Ʈ</td>
				<td>${content_view.bHit}</td> 
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" value="${content_view.bName}"></td> 
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" value="${content_view.bTitle}"></td> 
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="bContent" value="${content_view.bContent}"></td> 
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="����">
					&nbsp; &nbsp;<a href="delete?strId=${content_view.bId}">����</a>
					&nbsp; &nbsp;<a href="list">��Ϻ���</a>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>