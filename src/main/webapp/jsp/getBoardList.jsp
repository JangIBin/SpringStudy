<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="java.util.List" %>

<% 
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	// ����ȭ�� ����
%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<div align="center">
	<h1>�� ���</h1>
	<h3>
		�׽�Ʈ�� ȯ���մϴ�....
		<a href="logout_proc.jsp">Log-Out</a>
	</h3>
	<form action="getBoardList.jsp" method="post">
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
		<%
			for(BoardVO board : boardList) {
		%>
		<tr>
			<td><%=board.getSeq() %></td>
			<td align="left">
				<a href="getBoard.jsp?seq=<%=board.getSeq() %>"><%=board.getTitle() %></a>
			</td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegDate() %></td>
			<td><%=board.getCnt() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<br />
	<a href="insertBoard.jsp">���� ���</a>
	
</div>
</body>
</html>