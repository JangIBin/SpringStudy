<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="java.util.List" %>

<% 
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	// 응답화면 구성
%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<div align="center">
	<h1>글 목록</h1>
	<h3>
		테스트님 환영합니다....
		<a href="logout_proc.jsp">Log-Out</a>
	</h3>
	<form action="getBoardList.jsp" method="post">
		<table border="1" cellpadding="0" cellpadding="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
					</select>
					<input name="searchKeyword" type="text" />
					<input type="submit" value="검색" />
				</td>
			</tr>
		</table>
	</form>
	
	<table border="1" cellpadding="0" cellpadding="0" width="700">
		<tr>
			<th bgcolor="yellow" width="100">번호</th>
			<th bgcolor="yellow" width="200">제목</th>
			<th bgcolor="yellow" width="150">작성자</th>
			<th bgcolor="yellow" width="150">등록일</th>
			<th bgcolor="yellow" width="100">조회수</th>
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
	<a href="insertBoard.jsp">새글 등록</a>
	
</div>
</body>
</html>