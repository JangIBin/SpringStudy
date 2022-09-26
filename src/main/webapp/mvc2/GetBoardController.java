package com.global.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;


public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 상세보기 처리");
		
		// 1. 검색할 게시글 번호를 추출
		String seq = request.getParameter("seq");
		System.out.print(seq);
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		/*
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		*/
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); // Model 정보를 저장
		mav.setViewName("getBoard"); // View 정보를 저장
		
		return mav;
	}

}
