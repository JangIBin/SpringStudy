<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="java.util.List" %>

<%
	// 1. �˻��� �Խñ� ��ȣ�� ����
	String seq = request.getParameter("seq");

	// 2. DB ���� ó��
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� �� ����</title>
</head>
<body>
<div align="center">
	<form action="updateBoard_proc.jsp" method="post">
		<input type="hidden" name="seq" value="<%=board.getSeq() %>" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="yellow" width="70">����</td>
				<td align="left">
					<input type="text" name="title" value="<%=board.getTitle() %>" />
				</td>
			</tr>
			<tr>
				<td bgcolor="yellow">�ۼ���</td>
				<td align="left"><%=board.getWriter() %></td>
			</tr>
			<tr>
				<td bgcolor="yellow">����</td>
				<td align="left">
					<textarea rows="10" cols="40" name="content"><%=board.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td bgcolor="yellow">�����</td>
				<td align="left"><%=board.getRegDate() %></td>
			</tr>
			<tr>
				<td bgcolor="yellow">��ȸ��</td>
				<td align="left"><%=board.getCnt() %></td>
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
	<a href="deleteBoard_proc.jsp?seq=<%=board.getSeq() %>">�� ����</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">�� ���</a>
	
	
</div>
</body>
</html>