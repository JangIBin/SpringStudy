package com.global.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;


@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
    @Override
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Ŭ���̾�Ʈ�� ��û path ������ ������
		String uri = request.getRequestURI(); // BoardWeb/
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//(Model2) 2. Ŭ���̾�Ʈ��û�� path�� ���� ������ �б�ó���Ѵ�.
		//(MVC FrameWork) 2. HandleMapping�� ���� path�� �ش��ϴ� Controller�� �˻�
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. �˻��� Controller�� ����
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver�� ���ؼ� viewName�� �ش��ϴ� ȭ���� �˻���
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. �˻��� ȭ������ �̵��Ѵ�.
		response.sendRedirect(view);
		
		
		
		/*
		if(path.equals("/login.do")) {
			
		} else if(path.equals("/logout.do")) {
			
			
		} else if(path.equals("/insertBoard.do")) {
			
			
			
			
		} else if(path.equals("/updateBoard.do")) {
			
			
		} else if(path.equals("/deleteBoard.do")) {
			
			
		} else if(path.equals("/getBoard.do")) {
			
			
		} else if(path.equals("/getBoardList.do")) {
			
			
		}
		*/
	}

}
