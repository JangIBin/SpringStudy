<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>

<%
	// 1. 사용자의 정보 추출
	request.setCharacterEncoding("euc-kr");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	// 2. DB 연동
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	
	// 3. 화면 응답
	response.sendRedirect("getBoardList.jsp");
	
%>