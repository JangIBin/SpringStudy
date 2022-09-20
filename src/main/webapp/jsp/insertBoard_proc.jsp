<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.global.biz.board.BoardVO" %>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>

<%
	// 1. ������� ���� ����
	request.setCharacterEncoding("euc-kr");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 2. DB ����
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(vo);
	
	// 3. ȭ�� ����
	response.sendRedirect("getBoardList.jsp");
	
%>