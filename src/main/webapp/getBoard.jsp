<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� �� ����</title>
</head>
<body>
<div align="center">
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq }" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="yellow" width="70">����</td>
				<td align="left">
					<input type="text" name="title" value="${board.title }" />
				</td>
			</tr>
			<tr>
				<td bgcolor="yellow">�ۼ���</td>
				<td align="left">${board.writer }</td>
			</tr>
			<tr>
				<td bgcolor="yellow">����</td>
				<td align="left">
					<textarea rows="10" cols="40" name="content">${board.content }</textarea>
				</td>
			</tr>
			<tr>
				<td bgcolor="yellow">�����</td>
				<td align="left">${board.regDate }</td>
			</tr>
			<tr>
				<td bgcolor="yellow">��ȸ��</td>
				<td align="left">${board.cnt }</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="�� ����" />
				</td>
			</tr>
		</table>
	</form>
	<hr />
	<a href="insertBoard.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq }">�� ����</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">�� ���</a>
	
	
</div>
</body>
</html>