<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="com.global.biz.user.UserVO" %>
<%@ page import="com.global.biz.user.impl.UserDAO" %>

<% 
	// ����� �Է� ���� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// �����ͺ��̽� ����ó��
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// ȭ�� �׺���̼�
	if(user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	
	
%>