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

		// 1. 클라이언트의 요청 path 정보를 추출함
		String uri = request.getRequestURI(); // BoardWeb/
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//(Model2) 2. 클라이언트요청에 path에 따라 적절히 분기처리한다.
		//(MVC FrameWork) 2. HandleMapping을 통해 path에 해당하는 Controller를 검색
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해서 viewName에 해당하는 화면을 검색함
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동한다.
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
