<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<div align="center">
	<h1>�� ���</h1>
	<h3>
		�׽�Ʈ�� ȯ���մϴ�....
		<a href="logout.do">Log-Out</a>
	</h3>
	<form action="getBoardList.do" method="post">
		<table border="1" cellpadding="0" cellpadding="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">����</option>
						<option value="CONTENT">����</option>
					</select>
					<input name="searchKeyword" type="text" />
					<input type="submit" value="�˻�" />
				</td>
			</tr>
		</table>
	</form>
	
	<table border="1" cellpadding="0" cellpadding="0" width="700">
		<tr>
			<th bgcolor="yellow" width="100">��ȣ</th>
			<th bgcolor="yellow" width="200">����</th>
			<th bgcolor="yellow" width="150">�ۼ���</th>
			<th bgcolor="yellow" width="150">�����</th>
			<th bgcolor="yellow" width="100">��ȸ��</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.seq}</td>
				<td align="left">
					<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="insertBoard.jsp">���� ���</a>
	
</div>
</body>
</html>